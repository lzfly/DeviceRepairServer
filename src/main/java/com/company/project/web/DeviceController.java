package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import com.company.project.core.ServiceException;
import com.company.project.vo.DeviceRequestVO;
import com.company.project.service.DeviceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

/**
* Created by CodeGenerator on 2017/10/15.
*
* CheckPlan的Restful接口集合
*/
@RestController
@RequestMapping("/api")
public class DeviceController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    private DeviceService deviceService;

    /**
     * 用户的注册
     * @param CheckPlanRequestVO
     * @return
     */
    @ApiOperation(value="添加新Device", notes="注册一个Device")
    @RequestMapping(value = "/devices", method = RequestMethod.POST)
    public Result saveDevice(@RequestBody @Valid DeviceRequestVO requestDTO){
        Long userId = deviceService.saveDevice(requestDTO);

        return ResultGenerator.genSuccessResult(userId);
    }


    @ApiOperation(value="根据id删除Device", notes="根据url中的id来指定删除Device对象")
    @ApiImplicitParam(name = "id", value = "CheckPlan的id", required = true, dataType = "Long")
    @RequestMapping(value = "/devices/{id}", method = RequestMethod.DELETE)
    public Result deleteDevice(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(deviceService.deleteById(id));
    }


    @ApiOperation(value="更新Device信息", notes="根据url中的id来指定更新对象，并根据传过来的Device信息来更新user详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "CheckPlan的id", required = true)
    @RequestMapping(value = "/devices/{id}", method = RequestMethod.PUT)
    public Result updateDevice(@PathVariable Long id, @RequestBody DeviceRequestVO requestDTO) {
        return ResultGenerator.genSuccessResult(deviceService.updateDevice(id, requestDTO));
    }


    @ApiOperation(value="根据id查询Device", notes="根据url中的id来获取Device")
    @ApiImplicitParam(name = "id", value = "CheckPlan的id", required = true, dataType = "int")
    @RequestMapping(value = "/devices/{id}", method = RequestMethod.GET)
    public Result getDevice(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(deviceService.findById(id));
    }


    @ApiOperation(value="获取Device列表", notes="分页查询Device列表")
    @RequestMapping(value = "/alldevices", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
                                    @ApiImplicitParam(paramType = "query", name = "pageNo", value = "页码"),
                                   @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页大小")
    })
    @RolesAllowed({"ROLE_AUTHOR"})
    public Result listAllDevice(@RequestParam(defaultValue = "0", required = false) Integer pageNo,
                           @RequestParam(defaultValue = "0", required = false) Integer pagesize) {
        return ResultGenerator.genSuccessResult(deviceService.findAll(pageNo, pagesize));
    }
    
    @ApiOperation(value="获取公司Device列表", notes="分页查询公司Device列表")
    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
    		                       @ApiImplicitParam(paramType = "header", name = "token", value = "token", required = true),
                                   @ApiImplicitParam(paramType = "query", name = "pageNo", value = "页码"),
                                   @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页大小")
    })
    public Result listDevice(@RequestHeader("Authorization") String token,
    		               @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                           @RequestParam(defaultValue = "0", required = false) Integer pagesize) {
    	
        return ResultGenerator.genSuccessResult(deviceService.findAllByCompany(token, pageNo, pagesize));
    }

}
