package com.ruoyi.web.controller.custom;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.mask.MaskUtils;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.trans.service.ITblTransService;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.service.ITblUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 交易流水Controller
 *
 * @author ruoyi
 * @date 2024-07-20
 */
@Controller
@RequestMapping("/trans")
public class TransController extends BaseController {

    @Autowired
    private ITblTransService tblTransService;

    @Autowired
    private ITblUserInfoService tblUserInfoService;

    /**
     * 查询交易流水列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list() {

        TblUserInfo userInfo  = tblUserInfoService.selectTblUserInfoByUserId(getUserId());
        TblTrans tblTrans = new TblTrans();
        tblTrans.setUiId(userInfo.getUiId());
        startPage();
        List<TblTrans> list = tblTransService.selectTblTransList(tblTrans);
        list.forEach(MaskUtils::maskFields);
        return getDataTable(list);
    }
//
//    /**
//     * 导出交易流水列表
//     */
//    @Log(title = "交易流水", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(TblTrans tblTrans) {
//        TblUserInfo userInfo = new TblUserInfo();
//        userInfo.setUserId(getUserId());
//        List<TblUserInfo> tblUserInfos = tblUserInfoService.selectTblUserInfoList(userInfo);
//        if (tblUserInfos.isEmpty()) {
//            return null;
//        }
//        tblTrans.setUiId(tblUserInfos.get(0).getUiId());
//        List<TblTrans> list = tblTransService.selectTblTransList(tblTrans);
//        list.forEach(MaskUtils::maskFields);
//        ExcelUtil<TblTrans> util = new ExcelUtil<TblTrans>(TblTrans.class);
//        return util.exportExcel(list, "交易流水数据");
//    }
}
