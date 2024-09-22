package com.ruoyi.user.service;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.risk.domain.TblOperatorCard;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.route.domain.TblRouteInfo;
import com.ruoyi.system.domain.TblCardBinInfo;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.user.domain.TblUserChannelMapping;
import com.ruoyi.user.domain.TblUserInfo;
import com.ruoyi.user.domain.TblUserOpenCard;

import java.util.List;

/**
 * description: IOpenCardService <br>
 * date: 2024/7/21 23:01 <br>
 *
 *  <br>
 * @version: 1.0 <br>
 */
public interface IOpenCardService {

    /**
     *
     * @param tblUserInfo 用户基本信息
     *
     */
    public void saveCardHold( TblUserInfo tblUserInfo, TblChannelInfo tblChannelInfo) throws ServiceException;

    /**
     * 开卡
     *
     * @param tblUserChannelMapping 用户通道特性数据
     * @param tblUserInfo 用户基本信息
     * @param tblRouteInfo 路由信息
     *
     */
    public void openCard(TblUserChannelMapping tblUserChannelMapping, TblUserInfo tblUserInfo, TblRouteInfo tblRouteInfo, TblChannelInfo tblChannelInfo,TblUserOpenCard userOpenCard, String chargeAmt,String cardCurr)throws ServiceException;

    /**
     * 查询卡信息、状态和余额
     *
     *
     */
    public void queryCardInfoStatusAndBalance(TblUserOpenCard tblUserOpenCard, TblChannelInfo tblChannelInfo,String queryStatus);


    /**
     * 卡充值
     *
     *
     */
    public void recharge(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard, TblTrans tblTrans, String chargeAmt, String cardCurr);

    /**
     * 卡充值状态查询
     */
    public void rechargeQuery(TblChannelInfo tblChannelInfo, TblTrans tblTrans);

    /**
     * 开卡交易查询 返回开卡和开卡 充值两笔交易流水
     */
    public List<TblTrans> openCardQuery(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard);

    public boolean cancelCard(TblChannelInfo tblChannelInfo, TblUserOpenCard tblUserOpenCard, TblOperatorCard operatorCard);

}
