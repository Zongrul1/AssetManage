webpackJsonp([6],{216:function(t,e,a){a(414);var l=a(95)(a(309),a(423),null,null);t.exports=l.exports},309:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var l=a(96),o=a.n(l),n=a(50);e.default={data:function(){return{updateVisible:!1,insertVisible:!1,updateData:{id:" ",name:" ",value:" "},tableData:[]}},created:function(){var t=this;n.get("http://localhost:10088/cash/get-all").then(function(e){t.tableData=e.data.data}).catch(function(t){console.log(t)}),n.get("http://localhost:10088/cash/get-value").then(function(t){document.getElementById("v").innerHTML=t.data.data}).catch(function(t){console.log(t)})},methods:{handleEdit:function(t){this.updateData=o()({},t),this.updateVisible=!0},handleAdd:function(){this.insertVisible=!0},handleDelete:function(t){console.log(t);n.get("http://localhost:10088/cash/delete/"+t),window.location.reload()},update:function(){n.create({timeout:1e4})({url:"http://localhost:10088/cash/update",method:"post",data:this.updateData}),window.location.reload()},insert:function(){n.create({timeout:1e4})({url:"http://localhost:10088/cash/add",method:"post",data:this.updateData}),window.location.reload()}}}},319:function(t,e,a){e=t.exports=a(214)(!1),e.push([t.i,".customWidth{width:30%}.el-row{margin-bottom:20px}.el-col{border-radius:4px}.bg-purple-dark{background:#99a9bf}.bg-purple{background:#d3dce6}.bg-purple-light{background:#e5e9f2}.grid-content{border-radius:4px;height:36px}.total-value{padding:5px}.row-bg{padding:10px 0;background-color:#f9fafc}",""])},414:function(t,e,a){var l=a(319);"string"==typeof l&&(l=[[t.i,l,""]]),l.locals&&(t.exports=l.locals);a(215)("4391f32b",l,!0)},423:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-row",{staticStyle:{margin:"20px"},attrs:{gutter:20}},[a("el-col",{attrs:{span:4}},[a("div",{staticClass:"grid-content bg-purple"},[a("el-row",[a("el-col",{attrs:{span:12}},[a("div",{staticClass:"total-value"},[t._v("现金总价值：")])]),t._v(" "),a("el-col",{attrs:{span:6}},[a("div",{staticClass:"total-value",attrs:{id:"v"}})])],1)],1)]),t._v(" "),a("el-col",{attrs:{span:4}},[a("el-button",{staticStyle:{width:"150px"},attrs:{type:"primary"},on:{click:function(e){return t.handleAdd()}}},[t._v("\r\n    增加\r\n  ")])],1)],1),t._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData}},[a("el-table-column",{attrs:{prop:"name",label:"名称",width:"500"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-time"}),t._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.row.name))])]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"value",label:"价值",width:"500"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-time"}),t._v(" "),a("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.row.value))])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return t.handleEdit(e.row)}}},[t._v("编辑")]),t._v(" "),a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return t.handleDelete(e.row.id)}}},[t._v("删除")])]}}])})],1),t._v(" "),a("el-dialog",{attrs:{title:"修改",customClass:"customWidth"},model:{value:t.updateVisible,callback:function(e){t.updateVisible=e},expression:"updateVisible"}},[a("el-form",{ref:"updateData",attrs:{model:t.updateData}},[a("el-form-item",{attrs:{label:"名字","label-width":"50px"}},[a("el-input",{attrs:{"auto-complete":"off"},model:{value:t.updateData.name,callback:function(e){t.$set(t.updateData,"name",e)},expression:"updateData.name"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"价值","label-width":"50px"}},[a("el-input-number",{attrs:{"auto-complete":"off"},model:{value:t.updateData.value,callback:function(e){t.$set(t.updateData,"value",e)},expression:"updateData.value"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.updateVisible=!1}}},[t._v("取 消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.update()}}},[t._v("确 定")])],1)],1),t._v(" "),a("el-dialog",{attrs:{title:"增加",customClass:"customWidth"},model:{value:t.insertVisible,callback:function(e){t.insertVisible=e},expression:"insertVisible"}},[a("el-form",{ref:"updateData",attrs:{model:t.updateData}},[a("el-form-item",{attrs:{label:"名字","label-width":"50px"}},[a("el-input",{attrs:{"auto-complete":"off"},model:{value:t.updateData.name,callback:function(e){t.$set(t.updateData,"name",e)},expression:"updateData.name"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"价值","label-width":"50px"}},[a("el-input-number",{attrs:{"auto-complete":"off"},model:{value:t.updateData.value,callback:function(e){t.$set(t.updateData,"value",e)},expression:"updateData.value"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.insertVisible=!1}}},[t._v("取 消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.insert()}}},[t._v("确 定")])],1)],1)],1)},staticRenderFns:[]}}});