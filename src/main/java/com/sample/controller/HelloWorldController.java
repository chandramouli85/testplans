package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
//import com.philips.library.CalculatorUtil;

@RestController
public class HelloWorldController {

	
	  @ApiOperation(value = "", nickname = "sayhello", notes ="get the welcome ByPassing Name")
	  
	  @ApiResponses(value = {
	  
	  @ApiResponse(code = 200, message = "Ok"),
	  
	  @ApiResponse(code = 400, message = "Bad Request"),
	  
	  @ApiResponse(code = 401, message = "Not Authorized"),
	  
	  @ApiResponse(code = 403, message = "Forbidden"),
	  
	  @ApiResponse(code = 404, message = "Not Found"),
	  
	  @ApiResponse(code = 500, message = "Unexpected Error") })
	  
	  @GetMapping("/hello/{name}") 
	  public String sayhello(@ApiParam(value="get welcome msg with userName" ,required = true)@PathVariable String name) {
		  return "Welcome "+name;
		  }
			/*
			 * @GetMapping("addTwoNumbers/{num1}/{num2}") public int
			 * additionOfTwoNumber(@PathVariable int num1, @PathVariable int num2) { return
			 * CalculatorUtil.add(num1, num2); }
			 */

}
