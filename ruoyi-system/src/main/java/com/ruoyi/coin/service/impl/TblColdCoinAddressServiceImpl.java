package com.ruoyi.coin.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coin.mapper.TblColdCoinAddressMapper;
import com.ruoyi.coin.domain.TblColdCoinAddress;
import com.ruoyi.coin.service.ITblColdCoinAddressService;
import com.ruoyi.common.core.text.Convert;

/**
 * 冷钱包地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-28
 */
@Service
public class TblColdCoinAddressServiceImpl implements ITblColdCoinAddressService 
{
    @Autowired
    private TblColdCoinAddressMapper tblColdCoinAddressMapper;

    /**
     * 查询冷钱包地址
     * 
     * @param coinId 冷钱包地址主键
     * @return 冷钱包地址
     */
    @Override
    public TblColdCoinAddress selectTblColdCoinAddressByCoinId(Long coinId)
    {
        return tblColdCoinAddressMapper.selectTblColdCoinAddressByCoinId(coinId);
    }

    /**
     * 查询冷钱包地址列表
     * 
     * @param tblColdCoinAddress 冷钱包地址
     * @return 冷钱包地址
     */
    @Override
    public List<TblColdCoinAddress> selectTblColdCoinAddressList(TblColdCoinAddress tblColdCoinAddress)
    {
        return tblColdCoinAddressMapper.selectTblColdCoinAddressList(tblColdCoinAddress);
    }

    /**
     * 新增冷钱包地址
     * 
     * @param tblColdCoinAddress 冷钱包地址
     * @return 结果
     */
    @Override
    public int insertTblColdCoinAddress(TblColdCoinAddress tblColdCoinAddress)
    {
        return tblColdCoinAddressMapper.insertTblColdCoinAddress(tblColdCoinAddress);
    }

    /**
     * 新增冷钱包地址
     *
     * @param tblColdCoinAddress 冷钱包地址
     * @return 结果
     */
    @Override
    public int batchInsertTblColdCoinAddress(TblColdCoinAddress tblColdCoinAddress)
    {
//        if (Constants.COIN_TYPE.TRON_COIN.equals(tblColdCoinAddress.getCoinType())) {
//            for (int i = 0; i < tblColdCoinAddress.getGenNum(); i++) {
//                Map<String, String> address = TronUtils.createAddress(tblColdCoinAddress.getPrivateKey(), i);
//                tblColdCoinAddress.setCryCoinAddress(address.get("address"));
//                tblColdCoinAddress.setUsed("N");
//                tblColdCoinAddressMapper.insertTblColdCoinAddress(tblColdCoinAddress);
//            }
//        }
        return tblColdCoinAddress.getGenNum();
    }

    /**
     * 修改冷钱包地址
     * 
     * @param tblColdCoinAddress 冷钱包地址
     * @return 结果
     */
    @Override
    public int updateTblColdCoinAddress(TblColdCoinAddress tblColdCoinAddress)
    {
        return tblColdCoinAddressMapper.updateTblColdCoinAddress(tblColdCoinAddress);
    }

    /**
     * 批量删除冷钱包地址
     * 
     * @param coinIds 需要删除的冷钱包地址主键
     * @return 结果
     */
    @Override
    public int deleteTblColdCoinAddressByCoinIds(String coinIds)
    {
        return tblColdCoinAddressMapper.deleteTblColdCoinAddressByCoinIds(Convert.toStrArray(coinIds));
    }

    /**
     * 删除冷钱包地址信息
     * 
     * @param coinId 冷钱包地址主键
     * @return 结果
     */
    @Override
    public int deleteTblColdCoinAddressByCoinId(Long coinId)
    {
        return tblColdCoinAddressMapper.deleteTblColdCoinAddressByCoinId(coinId);
    }
}
