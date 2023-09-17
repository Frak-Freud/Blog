## 效果预览

<img src="https://s2.loli.net/2023/09/16/HC9kqGY37aL1dgN.jpg" style="zoom:50%;" />

### 后台管理页面

- 登录页

  <img src="static-files/login.png" alt="login" style="zoom:50%;" />

- 后台首页

  <img src="static-files/dashboard.png" alt="dashboard" style="zoom:50%;" />

- 文章管理

  <img src="static-files/blog-list.png" alt="blog-list" style="zoom:50%;" />

- 文章编辑

  <img src="static-files/edit.png" alt="edit" style="zoom:50%;" />

- 评论管理

  <img src="static-files/comment-list.png" alt="comment-list" style="zoom:50%;" />

- 系统配置

  <img src="static-files/config.png" alt="config" style="zoom:50%;" />

### 博客展示页面

项目中内置了三套博客主题模板，效果如下：

#### 模板一

- 首页

  <img src="static-files/index01.png" alt="index01" style="zoom:50%;" />

- 文章浏览

  <img src="static-files/detail01.png" alt="detail01" style="zoom:50%;" />

- 友情链接

  <img src="static-files/link01.png" alt="link01" style="zoom:50%;" />

#### 模板二

- 首页

  <img src="static-files/index02.png" alt="index02" style="zoom:50%;" />

- 文章浏览

  <img src="static-files/detail02.png" alt="detail02" style="zoom:50%;" />

- 友情链接

  <img src="static-files/link02.png" alt="link02" style="zoom:50%;" />

#### 模板三

- 首页

  <img src="static-files/index03.png" alt="index03" style="zoom:50%;" />

- 文章浏览

  <img src="static-files/detail03.png" alt="detail03" style="zoom:50%;" />

- 友情链接

  <img src="static-files/link03.png" alt="link03" style="zoom:50%;" />

## 数据库表

<img src="https://s2.loli.net/2023/09/16/ULx1EywagMATh3o.jpg" style="zoom: 80%;" />

- tb_admin_user            用户表

<img src="https://s2.loli.net/2023/09/16/rdFa2TkfH8A73Lt.jpg" style="zoom:50%;" />

- tb_ blog                       博客表

  <img src="https://s2.loli.net/2023/09/16/PActkVdjMnwTf9v.jpg" style="zoom:50%;" />

- tb_blog_category        博客分类表

  <img src="https://s2.loli.net/2023/09/16/Nfo7JbHEpkYMCZ6.jpg" style="zoom:50%;" />

- tb_blog_comment       博客评论表

  <img src="https://s2.loli.net/2023/09/16/PoF4TU2p9wemNRc.jpg" style="zoom:50%;" />

- tb_blog_tag                 标签表

  <img src="https://s2.loli.net/2023/09/16/HwzbRGTi9cN5Sem.jpg" style="zoom:67%;" />

- tb_blog_tag_relation   博客标签 relation 表

  <img src="https://s2.loli.net/2023/09/16/MOQBr6oJ8zdUASC.jpg" style="zoom:80%;" />

- tb_config                     footer等信息表

  <img src="https://s2.loli.net/2023/09/16/fo7r2b1H3yqChan.jpg" style="zoom:80%;" />

- tb_link                         友链表

  <img src="https://s2.loli.net/2023/09/16/lVAWiv2IrxqdgnO.jpg" style="zoom:50%;" />



## 知识点总结

博客系统涉及到的后端技术栈如下：

- Spring Boot
- MyBatis
- Thymeleaf
- kaptcha

博客系统涉及到的前端技术栈如下：

- AdminLTE3
- BootStrap
- JqGrid
- ajax
- Editor.md



## 功能模块

后台管理系统中包含如下模块：管理员登录、身份认证、菜单设置、博客管理、文件上传及管理、markdown 文章编辑器整合、分类管理、标签管理、友链管理、评论管理、系统设置、数据统计及常用的交互功能。

<img src="https://s2.loli.net/2023/09/16/iWNEx5KgMmdP3hH.jpg" style="zoom:50%;" />

前台网站则包括：博客首页、博客搜索、博客浏览、博客评论、友链展示等功能模块。

<img src="https://s2.loli.net/2023/09/16/VlSL1Gjg4aeYxk3.jpg" style="zoom:50%;" />
