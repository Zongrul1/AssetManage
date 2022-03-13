<template>
<div>
  <el-row :gutter="20" style="margin: 20px">
  <el-col :span="4"><div class="grid-content bg-purple">
      <el-row>
        <el-col :span="14"><div class="total-value">支付宝总价值：</div></el-col>
        <el-col :span="6"><div class="total-value" id="v"></div></el-col>
      </el-row>
    </div>
    </el-col>
  <el-col :span="4">  
    <el-button type="primary" style="width: 150px" @click="handleAdd()">
    增加
  </el-button></el-col>
</el-row>

  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      prop="name"
      label="名称"
      width="500">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.name}}</span>
      </template>
    </el-table-column>
    <el-table-column
      prop="value"
      label="价值"
      width="500">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.value }}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
 
  <el-dialog title="修改" customClass="customWidth" v-model="updateVisible">
<el-form :model="updateData" ref="updateData">
  <el-form-item label="名字"  label-width="50px">
    <el-input  auto-complete="off" v-model="updateData.name"></el-input>
  </el-form-item>
  <el-form-item label="价值"  label-width="50px">
    <el-input-number  auto-complete="off" v-model="updateData.value"></el-input-number>
</el-form-item>
</el-form>
<div slot="footer" class="dialog-footer">
<el-button @click="updateVisible = false">取 消</el-button>
<el-button type="primary"  @click="update()">确 定</el-button>
</div>
</el-dialog>

  <el-dialog title="增加" customClass="customWidth" v-model="insertVisible">
<el-form :model="updateData" ref="updateData">
  <el-form-item label="名字"  label-width="50px">
    <el-input  auto-complete="off" v-model="updateData.name"></el-input>
  </el-form-item>
  <el-form-item label="价值"  label-width="50px">
    <el-input-number  auto-complete="off" v-model="updateData.value"></el-input-number>
</el-form-item>
</el-form>
<div slot="footer" class="dialog-footer">
<el-button @click="insertVisible = false">取 消</el-button>
<el-button type="primary"  @click="insert()">确 定</el-button>
</div>
</el-dialog>
</div>
  
  
  
</template>

<script>
    const axios = require('axios');
  export default {
    data() {
      return {
        updateVisible: false,
        insertVisible: false,
        updateData:{
          id:" ",
          name:" ",
          value:" "
        },
        tableData: [
        ],
      }
    },
    created () {
        axios.get('http://localhost:10088/alipay/get-all')
        .then((response) => {
           this.tableData = response.data.data
        })
        .catch((error) => {
            console.log(error);
        });
        axios.get('http://localhost:10088/alipay/get-value')        
        .then((response) => {
           document.getElementById("v").innerHTML=response.data.data;
        })
        .catch((error) => {
            console.log(error);
        });
    },
    methods: {
      handleEdit(row) {
        this.updateData = Object.assign({}, row);//将数据传入dialog页面
        this.updateVisible = true;
      },
      handleAdd() {
        this.insertVisible = true;
      },
      handleDelete(id) {
        console.log(id)
        var url = "http://localhost:10088/alipay/delete/"
        axios.get(url + id)
        window.location.reload()
      },
      update(){
        const request = axios.create({
            timeout: 10000
        });
        request({
          url:'http://localhost:10088/alipay/update',
          method:'post',
          data:this.updateData//注意这里不需要转成json字符串，axios会自动识别该数据是form表单数据还是对象数据
      });
        window.location.reload()
      },
      insert(){
        const request = axios.create({
            timeout: 10000
        });
        request({
          url:'http://localhost:10088/alipay/add',
          method:'post',
          data:this.updateData//注意这里不需要转成json字符串，axios会自动识别该数据是form表单数据还是对象数据
      });
        window.location.reload()
      }
    }
  }
</script>


<style>
    .customWidth{
    width:30%;
    }
  .el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    height: 36px;
  }
  .total-value{
    padding: 5px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>

