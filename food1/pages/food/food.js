var app = getApp();
var that = '';
Page({
  data: {
    img: 'images/introduce.png',
    imgB64: '',
    content: '',
    ishow: false,
    circleList: [],
    colorCircleFirst: '#FFDF2F',
    colorCircleSecond: '#FE4D32',
  },
  onLoad: function (options) {
    that = this;
  },
  goToHistoryPage: function goToHistoryPage() {
    wx.navigateTo({
      url: '../list/list'
    });
  },
  twinkle:function(){
    setInterval(function () {
      if (that.data.colorCircleFirst == '#FFDF2F') {
        that.setData({
          colorCircleFirst: '#FE4D32',
          colorCircleSecond: '#FFDF2F',
        })
      } else {
        that.setData({
          colorCircleFirst: '#FFDF2F',
          colorCircleSecond: '#FE4D32',
        })
      }
    }, 500)
  },
  chooseImg: function () {
    that.setData({
      ishow: false,
      content: ''
    });
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success(res) {
        const tempFilePaths = res.tempFilePaths[0];
        that.getB64ByUrl(tempFilePaths);
        that.setData({
          img: tempFilePaths
        });
      }
    })
  },
  getB64ByUrl: function (url) {
    const FileSystemManager = wx.getFileSystemManager();
    FileSystemManager.readFile({
      filePath: url,
      encoding: 'base64',
      success(res) {
        that.setData({
          imgB64: res.data
        });
      }
    })
  },
  
  foodTap: function (e) {
    const imgB64 = that.data.imgB64;
    if (!imgB64) {
      wx.showToast({
        title: '请上传图片',
      })
      return;
    };
    that.twinkle()
    that.getToken(function (token) {
      that.getResult(token);
    });
  },
  getToken: function (callback) {
    wx.request({
      url: 'https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=4uICksD30g7kyKIq05gWmy7i&client_secret=zFlQ5a6P9Pr486sVTrhYaassFCCB5M9Y',
      data: {},
      header: {
        'content-type': 'application/x-www-form-urlencoded' 
      },
      success(res) {
        var token = res.data.access_token;
        return callback(token);
      }
    });
  },
  getResult: function (token) {
    wx.request({
      url: 'https://aip.baidubce.com/rest/2.0/image-classify/v2/dish?access_token=' + token,
      method: "post",
      data: {
        image: that.data.imgB64,
        baike_num: 1,
        top_num: 1
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success(res) {
        that.setData({
          dishName: res.data.result[0].name,
          calorie: res.data.result[0].calorie,
          probability: res.data.result[0].probability,
          description: res.data.result[0].baike_info.description,
          image_url: res.data.result[0].baike_info.image_url,                    
          baike_url: res.data.result[0].baike_info.baike_url
        });
        var that1=that.data;
        var disharea=new Array();
        
        disharea[0]=res.data.result[0].name;
        disharea[1]=res.data.result[0].calorie;
        disharea[2]=res.data.result[0].probability;
        disharea[3]=res.data.result[0].baike_info.description;
        
        wx.request({
          url: "https://www.xyh.best/dish/adddish",
          data: JSON.stringify(that1),
          method: 'POST',
          header: {
            'Content-Type': 'application/json'
          },
          success: function success(res) {
            var result = res.data.success;
            var toastText = "操作成功！";
            if (result != true) {
              toastText = "操作失败" + res.data.errMsg;
            }
            wx.showToast({
              title: toastText,
              icon: '',
              duration: 2000
            });
          }
        });
        wx.showModal({
          title: '菜品为' +that.data.dishName,
          content:'置信度'+that.data.probability+' '+'热量为' + that.data.calorie+'\n是否查看详情',
          success(res){
            if (res.confirm) {
              that.setData({ishow:true}) 
            }
            else{
              return
            }
          }
        })
      }
    });
  },
  sendJson: function (Array) {
  }
})
