package com.botany.jasmine.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author wangzh
 */
@Api(description = "swagger demo")
@Controller
@RequestMapping("/api/swagger")
public class SwaggerDemoController {

  @ApiOperation("say hello")
  @ApiImplicitParams({@ApiImplicitParam(paramType="cookie", name = "loginId", dataTypeClass = String.class),
                      @ApiImplicitParam(paramType="cookie", name = "token", dataTypeClass = String.class)})
  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity sayHello(@RequestParam String name) {

    return new ResponseEntity(HttpStatus.OK);
  }
}
