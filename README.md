# ampm-cicd-reference-application
Ambulatory Platform Module

# scheduled workflow for Hp Fortify_Scan
We have given the 3 Triggers like
* workflow_dispatch
* repository_dispatch
* schedule
If schedule is not triggered properly as expected then we will use repository_dispatch to trigger by using external server or linux/unix commands.

name: Fortify_scan
on:
  workflow_dispatch:       #Triggering manually.
  repository_dispatch:     #Triggering by using external linux/unix commands.
   types: [build]
  schedule:                #Triggering at 2AM on every 2 days.
   - cron: "0 2 */2 * *"
   
jobs:
  Fortify_scan:
    runs-on: [self-hosted, Linux, X64, fortify ]
    if: github.event.ref == 'refs/heads/main'
    
    steps:
      - name: Step 1 - Checkout Repository from GitHub
        uses: actions/checkout@v2
          
      - name: Step 2 - scanning and generating FPR file
        run: |
          sourceanalyzer -b reference-application -clean
          sourceanalyzer -b reference-application -source 11 /home/philips/actions-runner/_work/ampm-cicd-reference-application/ampm-cicd-reference-application/
          sourceanalyzer -b reference-application -scan -f reference-application.fpr
      - name: Step 3 - Publish to Fortify Server
        run: |
          fortifyclient -url https://fortify.philips.com/ssc -authtoken ${{ secrets.fortify_token }} uploadFPR -file reference-application.fpr -project "Ambulatory Platform"  -version 1.0

