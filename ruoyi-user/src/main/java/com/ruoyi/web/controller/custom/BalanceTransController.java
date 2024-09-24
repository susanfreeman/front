package com.ruoyi.web.controller.custom;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.trans.domain.TblBalanceTrans;
import com.ruoyi.trans.service.ITblBalanceTransService;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.service.ITblUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 余额变动Controller
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/baltrans")
public class BalanceTransController extends BaseController
{

    @Autowired
    private ITblBalanceTransService tblBalanceTransService;

    @Autowired
    private ITblUserInfoService tblUserInfoService;

    /**
     * 查询余额变动列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        TblUserInfo userInfo = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        TblBalanceTrans tblBalanceTrans = new TblBalanceTrans();
        tblBalanceTrans.setUiId(userInfo.getUiId());
        startPage();
        List<TblBalanceTrans> list = tblBalanceTransService.selectTblBalanceTransList(tblBalanceTrans);
        return getDataTable(list);
    }

//    /**
//     * 导出余额变动列表
//     */
//    @Log(title = "余额变动", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(TblBalanceTrans tblBalanceTrans)
//    {
//        List<TblBalanceTrans> list = tblBalanceTransService.selectTblBalanceTransList(tblBalanceTrans);
//        ExcelUtil<TblBalanceTrans> util = new ExcelUtil<TblBalanceTrans>(TblBalanceTrans.class);
//        return util.exportExcel(list, "余额变动数据");
//    }
}
