# springboot-elasticsearch

在 elasticsearch 中 的内容与　mysql的部分概念相对应

index <--------------------->database

type<----------------------->table

ducument<------------------->row 行

field<--------------------->column　列


所以，初步可以把 elasticsearch　当初一种新的数据库

idea,elasticsearch-7.3.2,springboot

本项目由于时间关系，初步实现了用户管理功能
１．用户的添加
２．用户的删除（根据id或者username进行删除操作）
３．用户的修改）（根据id或者username进行修改操作）
４．用户的查询　（根据id或者username进行查询操作）
５．批量查询（尚未完善，目前数据少，直接查询所有，如果数据量增大，可改成分页查询，每次显示指定数据信息）

