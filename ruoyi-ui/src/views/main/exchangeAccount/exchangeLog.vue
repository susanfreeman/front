<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      兑换记录
    </div>

    <ul class="log_list">
<!--      <div class="no_data">-->
<!--        <img src="../../../assets/no-data.png" alt="" />-->
<!--        <p>没有记录</p>-->
<!--      </div>-->

      <el-table v-loading="loading" :data="exchangeList" >
        <el-table-column label="变动类型" align="center" prop="ubType" width="100" >
            <template slot-scope="scope">
              <dict-tag :options="dict.type.bus_bal_type" :value="scope.row.ubType"/>
            </template>
        </el-table-column>
        <el-table-column label="交易变动前金额" align="center" prop="transBeforeAmt" width="100" />
        <el-table-column label="变动金额" align="center" prop="transAmt" width="100" />
        <el-table-column label="变动后金额" align="center" prop="transAfterAmt" width="100" />
        <el-table-column label="交易币种" align="center" prop="transCurr" width="100" />
        <el-table-column label="备注" align="center" prop="remark" width="100" />
        <el-table-column label="交易时间" align="center" prop="transTime" width="100">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.transTime) }}</span>
          </template>
        </el-table-column>
      </el-table>

      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="queryBaltrans"
      />

    </ul>
  </div>
</template>

<script>
import {getBaltrans} from "@/api/custom/trans";

  export default {
    dicts: ['bus_bal_type'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 总条数
        total: 0,
        // 公告表格数据
        exchangeList: [],
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          noticeTitle: undefined,
          createBy: undefined,
          status: undefined
        },
      }
    },
    created() {
      this.queryBaltrans();
    },
    methods: {
      handleBack() {
        this.$router.push('/home/exchange-account/exchange')
      },

      queryBaltrans() {
        this.loading = true;
        getBaltrans(this.queryParams).then(res => {
          if (res.code == 200) {
            this.exchangeList = res.rows;
            this.total = res.total;
            this.loading = false;
          }
        })
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
    @media screen and (min-width: 600px) {
      height: 685px !important;
    }
    .pc_back {
      display: flex;
      font-size: 16px;
      margin-bottom: 32px;
      font-weight: 700;
      color: #333;
      cursor: pointer;
      align-items: center;
      i {
        margin-right: 10px;
      }
    }
    .log_list {
      width: 100%;
      height: calc(100vh - 44px);
      overflow: auto;
      padding-left: 16px;
      @media screen and (max-width: 600px) {
        height: 90% !important;
      }
      .no_data {
        width: 100%;
        height: 240px;
        background: #fff;
        border-radius: 0 0 4px 4px;
        overflow: hidden;
        img {
          display: block;
          margin: 66px auto 10px;
        }
        p {
          font-size: 12px;
          color: #333;
          text-align: center;
        }
      }
    }
  }
</style>
