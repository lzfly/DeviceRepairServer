package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import com.company.project.core.ServiceException;
import com.company.project.vo.RepairItemRequestVO;
import com.company.project.service.RepairItemService;
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
public class RepairItemController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RepairItemController.class);

    @Autowired
    private RepairItemService repairItemService;

    /**
     * 用户的注册
     * @param RepairItemRequestVO
     * @return
     */
    @ApiOperation(value="添加新RepairItem", notes="注册一个RepairItem")
    @RequestMapping(value = "/repairitems", method = RequestMethod.POST)
    public Result saveRepairItem(@RequestBody @Valid RepairItemRequestVO requestDTO){
        Long userId = repairItemService.saveRepairItem(requestDTO);

        return ResultGenerator.genSuccessResult(userId);
    }


    @ApiOperation(value="根据id删除RepairItem", notes="根据url中的id来指定删除RepairItem对象")
    @ApiImplicitParam(name = "id", value = "RepairItem的id", required = true, dataType = "Long")
    @RequestMapping(value = "/repairitems/{id}", method = RequestMethod.DELETE)
    public Result deleteRepairItem(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(repairItemService.deleteById(id));
    }


    @ApiOperation(value="更新RepairItem信息", notes="根据url中的id来指定更新对象，并根据传过来的RepairItem信息来更新user详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "RepairItem的id", required = true)
    @RequestMapping(value = "/repairitems/{id}", method = RequestMethod.PUT)
    public Result updateRepairItem(@PathVariable Long id, @RequestBody RepairItemRequestVO requestDTO) {
        return ResultGenerator.genSuccessResult(repairItemService.updateRepairItem(id, requestDTO));
    }


    @ApiOperation(value="根据id查询RepairItem", notes="根据url中的id来获取RepairItem")
    @ApiImplicitParam(name = "id", value = "RepairItem的id", required = true, dataType = "int")
    @RequestMapping(value = "/repairitems/{id}", method = RequestMethod.GET)
    public Result getRepairItem(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(repairItemService.findById(id));
    }


    @ApiOperation(value="获取RepairItem列表", notes="分页查询RepairItem列表")
    @RequestMapping(value = "/allrepairitems", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
                                    @ApiImplicitParam(paramType = "query", name = "pageNo", value = "页码"),
                                   @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页大小")
    })
    @RolesAllowed({"ROLE_AUTHOR"})
    public Result listAllRepairItem(@RequestParam(defaultValue = "0", required = false) Integer pageNo,
                           @RequestParam(defaultValue = "0", required = false) Integer pagesize) {
        return ResultGenerator.genSuccessResult(repairItemService.findAll(pageNo, pagesize));
    }
    
    @ApiOperation(value="获取RepairItem列表", notes="分页查询RepairItem列表")
    @RequestMapping(value = "/repairitems", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
    		                       @ApiImplicitParam(paramType = "header", name = "token", value = "token", required = true),
                                   @ApiImplicitParam(paramType = "query", name = "pageNo", value = "页码"),
                                   @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页大小")
    })
    public Result listRepairItem(@RequestHeader("Authorization") String token,
    		               @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                           @RequestParam(defaultValue = "0", required = false) Integer pagesize) {
        return ResultGenerator.genSuccessResult(repairItemService.findAllByCompany(token, pageNo, pagesize));
    }

}
