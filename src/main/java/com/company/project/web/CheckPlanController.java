package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import com.company.project.core.ServiceException;
import com.company.project.vo.CheckPlanRequestVO;
import com.company.project.service.CheckPlanService;
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
public class CheckPlanController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CheckPlanController.class);

    @Autowired
    private CheckPlanService checkPlanService;

    /**
     * 用户的注册
     * @param CheckPlanRequestVO
     * @return
     */
    @ApiOperation(value="添加新CheckPlan", notes="注册一个CheckPlan")
    @RequestMapping(value = "/checkplans", method = RequestMethod.POST)
    public Result saveCheckPlan(@RequestBody @Valid CheckPlanRequestVO requestDTO){
        Long userId = checkPlanService.saveCheckPlan(requestDTO);

        return ResultGenerator.genSuccessResult(userId);
    }


    @ApiOperation(value="根据id删除CheckPlan", notes="根据url中的id来指定删除CheckPlan对象")
    @ApiImplicitParam(name = "id", value = "CheckPlan的id", required = true, dataType = "Long")
    @RequestMapping(value = "/checkplans/{id}", method = RequestMethod.DELETE)
    public Result deleteCheckPlan(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(checkPlanService.deleteById(id));
    }


    @ApiOperation(value="更新CheckPlan信息", notes="根据url中的id来指定更新对象，并根据传过来的CheckPlan信息来更新user详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "CheckPlan的id", required = true)
    @RequestMapping(value = "/checkplans/{id}", method = RequestMethod.PUT)
    public Result updateCheckPlan(@PathVariable Long id, @RequestBody CheckPlanRequestVO requestDTO) {
        return ResultGenerator.genSuccessResult(checkPlanService.updateCheckPlan(id, requestDTO));
    }


    @ApiOperation(value="根据id查询CheckPlan", notes="根据url中的id来获取CheckPlan")
    @ApiImplicitParam(name = "id", value = "CheckPlan的id", required = true, dataType = "int")
    @RequestMapping(value = "/checkplans/{id}", method = RequestMethod.GET)
    public Result getCheckPlan(@PathVariable Long id) {
        return ResultGenerator.genSuccessResult(checkPlanService.findById(id));
    }


    @ApiOperation(value="获取CheckPlan列表", notes="分页查询CheckPlan列表")
    @RequestMapping(value = "/checkplans", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
                                    @ApiImplicitParam(paramType = "query", name = "pageNo", value = "页码"),
                                   @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页大小")
    })
    @RolesAllowed({"ROLE_AUTHOR"})
    public Result listCheckPlan(@RequestParam(defaultValue = "0", required = false) Integer pageNo,
                           @RequestParam(defaultValue = "0", required = false) Integer pagesize) {
        return ResultGenerator.genSuccessResult(checkPlanService.findAll(pageNo, pagesize));
    }

}
