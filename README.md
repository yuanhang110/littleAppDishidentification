# littleAppDishidentification

菜品识别的微信小程序

项目码云链接：https://gitee.com/summer_school/cn.edu.xju.group5

项目描述：

微信小程序通过调用摄像头拍照或者从相册获得菜品图片的信息，再调用接口返回识别后具体的菜名、卡路里、置信度信息。可以从数据库中获取查询的历史纪录。

负责部分：

图像识别部分，将图片信息通过图像识别接口用POST方式上传到百度智能云平台的图像识别服务得到JSON格式的字符串。将JSON格式的字符串利用阿里的Fastjson库转换字符串，获得想要格式的信息存到控件中。

后台部分，使用SpringBoot和Mybatis编写后台代码。完成识别菜品后添加一条纪录到MySQL数据库中，从数据库中获取查询的历史纪录。将项目部署到Docker容器上。
