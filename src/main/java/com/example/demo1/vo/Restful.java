package com.example.demo1.vo;

/**
 * 封装返回实体类
 *@author : yu
 *@data   :2022/7/8 9:25
 *@description: some description
 */
public class Restful {


    private Integer code;

    private String message;

    private Object data;

    /**
     * 查询返回数据
     * @param data 写入对应查询到的数据
     * @return
     */
    public static Restful ok(Object data){
        Restful restful=new Restful();
        restful.setCode(200);
        restful.setMessage("数据获取成功");
        restful.setData(data);
        return restful;
    }

    /**
     * 封装返回前端message的数据
     * @param message 返回数据
     * @param data 查询出来需要返回的数据
     * @return
     */
    public static Restful okMessage(String message,Object data){
        Restful restful=new Restful();
        restful.setCode(200);
        restful.setMessage(message);
        restful.setData(data);
        return restful;
    }

    /**
     * 封装错误返回结果
     * @return
     */
    public static Restful fail(){
        Restful restful=new Restful();
        restful.setCode(400);
        restful.setMessage("数据获取失败");
        return restful;
    }


    /**
     * 封装message
     * @return
     */
    public static Restful messageFail(String message){
        Restful restful=new Restful();
        restful.setMessage(message);
        restful.setCode(400);
        return restful;
    }

    /**
     * 返回一个错误对象给前端做判断  避免前端出现空值异常
     * @param message
     * @param data
     * @return
     */
    public static Restful messageFail(String message,Object data){
        Restful restful=new Restful();
        restful.setMessage(message);
        restful.setCode(400);
        restful.setData(data);
        return restful;
    }



    @Override
    public String toString() {
        return "Restful{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Restful() {
    }

    public Restful(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
