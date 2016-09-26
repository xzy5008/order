**接口说明**

所有返回JSON格式都为
```javascript
{"data":null,"message":"删除成功","status":0}
```
1. `data`    请求接口的具体数据,可能为`""`或`null`
2. `message` 请求接口的提示信息,可能为`""`或`null`
3. `error`   请求接口的错误代码,当`error = 0`,请求成功

接口|说明|请求类型|参数|返回data类型
---|----|-------|---|---
`/tools`     |返回所有商业画布      |`GET` |     |`array`
`/tools/bmcanvases/{id}`|获得指定的商业画布|`GET`|       |`object`
`/tools/bmcanvases`     |新建一个商业画布      |`POST`|`title`|`object`
`/tools/bmcanvases/{id}`|修改指定的商业画布|`PUT`| `title`|`object`
`/tools/bmcanvases/{id}`|删除指定的商业画布|`DELETE`|     |
`/tools/bmcanvases/{id}/buildingblocks`|获得所有构造块|`GET`|     |`array`
`/tools/bmcanvases/{id}/buildingblocks/{bId}`|获得指定构造块|`GET`|     |`object`
`/tools/bmcanvases/{id}/buildingblocks/{bId}/notes`|获得指定构造块下的所有便利贴|`GET`|     |`array`
`/tools/bmcanvases/{id}/buildingblocks/{bId}/notes/{nId}`|获得指定构造块下的指定的便利贴|`GET`|     |`object`
`/tools/bmcanvases/{id}/buildingblocks/{bId}/notes`|创建便利贴|`POST`|`content`,`color`|`object`
`/tools/bmcanvases/{id}/buildingblocks/{bId}/notes/{nId}`|修改便利贴|`PUT`|`content`,`color`|`object`
`/tools/bmcanvases/{id}/buildingblocks/{bId}/notes/{nId}`|删除便利贴|`DELETE`|     |`object`
Todolist
- [x] 商业画布基本增删改查
- [x] 便利贴基本增删改查
- [x] 带有条件的筛选
- [x] 表单验证