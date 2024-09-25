<template>
  <div class="pc">
    <p class="title">公告</p>
    <p class="title2">来自官方的发布</p>

    <ul class="list">
      <li  @click="toDetail(item)" v-for="item in noticeList" >
        {{item.noticeTitle}}
<!--        <router-link :to="{ name: 'notice-detail', params: { id: item.id }}">{{item.noticeTitle}}</router-link>-->
      </li>
    </ul>

<!--    <el-table v-loading="loading" :data="noticeList" >-->
<!--      <el-table-column-->
<!--        label="公告标题"-->
<!--        align="center"-->
<!--        prop="noticeTitle"-->
<!--        :show-overflow-tooltip="true"-->
<!--      />-->
<!--      <el-table-column label="创建时间" align="center" prop="createTime" width="100">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->


<!--    <pagination-->
<!--      v-show="total>0"-->
<!--      :total="total"-->
<!--      :page.sync="queryParams.pageNum"-->
<!--      :limit.sync="queryParams.pageSize"-->
<!--      @pagination="getList"-->
<!--    />-->
  </div>
</template>

<script>
  import {listNotice} from "@/api/system/notice";

  export default {
    data() {
      return {
        // 遮罩层
        loading: true,
        // 总条数
        total: 0,
        // 公告表格数据
        noticeList: [],
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
      this.getList();
    },
    methods: {
      /** 查询公告列表 */
      getList() {
        this.loading = true;
        listNotice(this.queryParams).then(response => {
          this.noticeList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
        toDetail(notice) {
          console.log(notice);
            this.$router.push({name:"notice-detail",params: {
                notice: notice
          }}
        )
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
    .title {
      font-weight: 700;
      font-size: 24px;
      padding-left: 16px;
      margin-top: 32px;
      color: #000;
    }
    .title2 {
      font-size: 12px;
      padding-left: 16px;
      margin-bottom: 16px;
      color: #ccc;
    }
    .list {
      position: relative;
      z-index: 1;
      li {
        width: 100%;
        height: 70px;
        padding: 0 16px;
        font-size: 14px;
        color: #333;
        border-bottom: 1px solid #f5f5f8;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-weight: 700;
      }
    }
  }
</style>
