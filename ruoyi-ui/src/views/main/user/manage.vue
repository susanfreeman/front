<template>
  <div class="pc_inner">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      卡片管理
    </div>

    <div class="is_on">
      <span>隐藏卡片关键信息</span>
      <el-switch v-model="value" active-color="#34c759" inactive-color="#666">
      </el-switch>
    </div>

    <div class="is_on">
      <span>卡片余额不足提醒(预付卡)</span>
      <el-switch v-model="value2" active-color="#34c759" inactive-color="#666">
      </el-switch>
    </div>

    <el-radio-group v-model="radio1" class="manage-radio-group">
      <el-radio-button label="20 USD"></el-radio-button>
      <el-radio-button label="100 USD"></el-radio-button>
      <el-radio-button label="200 USD"></el-radio-button>
    </el-radio-group>

    <div class="title1">卡片顺序</div>
    <div class="title2">
      <span>更改首页卡片展示顺序</span>
      <span>长按拖动</span>
    </div>

    <el-tree
      :data="data"
      node-key="id"
      default-expand-all
      @node-drag-start="handleDragStart"
      @node-drag-enter="handleDragEnter"
      @node-drag-leave="handleDragLeave"
      @node-drag-over="handleDragOver"
      @node-drag-end="handleDragEnd"
      @node-drop="handleDrop"
      draggable
      :allow-drop="allowDrop"
      :allow-drag="allowDrag"
    >
    </el-tree>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        value: false,
        value2: false,
        radio1: '20 USD',

        data: [
          {
            id: 1,
            label: '一级 1'
          },
          {
            id: 2,
            label: '一级 2'
          },
          {
            id: 3,
            label: '一级 3'
          }
        ],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      }
    },
    methods: {
      handleBack() {
        this.$router.push('/home/user/me')
      },

      handleDragStart(node, ev) {
        console.log('drag start', node)
      },
      handleDragEnter(draggingNode, dropNode, ev) {
        console.log('tree drag enter: ', dropNode.label)
      },
      handleDragLeave(draggingNode, dropNode, ev) {
        console.log('tree drag leave: ', dropNode.label)
      },
      handleDragOver(draggingNode, dropNode, ev) {
        console.log('tree drag over: ', dropNode.label)
      },
      handleDragEnd(draggingNode, dropNode, dropType, ev) {
        console.log('tree drag end: ', dropNode && dropNode.label, dropType)
      },
      handleDrop(draggingNode, dropNode, dropType, ev) {
        console.log('tree drop: ', dropNode.label, dropType)
      },
      allowDrop(draggingNode, dropNode, type) {
        if (dropNode.data.label === '二级 3-1') {
          return type !== 'inner'
        } else {
          return true
        }
      },
      allowDrag(draggingNode) {
        return draggingNode.data.label.indexOf('三级 3-2-2') === -1
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc_inner {
    width: 602px;
    margin: 60px auto;
    border-radius: 14px;
    background: #fff;
    padding: 34px 32px 9px;
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
    .is_on {
      width: 100%;
      height: 52px;
      border-bottom: 1px solid #f5f5f8;
      padding: 0 16px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      font-weight: 700;
      color: #333;
    }
    .title1 {
      font-weight: 700;
      color: #333;
      margin: 16px 0 10px;
    }
    .title2 {
      height: 18px;
      font-size: 12px;
      font-weight: 400;
      color: #333;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
  }
</style>
<style lang="less">
  .manage-radio-group {
    width: 100%;
    display: flex;
    padding: 5px !important;
    .el-radio-button {
      flex: 1;
      background: rgba(118, 118, 128, 0.12);
      .el-radio-button__inner {
        width: 100%;
        background: rgba(118, 118, 128, 0.12);
        font-weight: 400;
        color: #000;
      }
    }
    .el-radio-button.is-active {
      .el-radio-button__inner {
        width: 100%;
        background: #fff;
        font-weight: 700;
      }
    }
  }
</style>
