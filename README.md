# hamster
By Parck.
## What is this ?
一个微信API库。
## How to use ?
spring-applicationContext.xml
```
<bean class="cn.edots.hamster.core.RetrofitAutowiredProcessor"/>
```
controller
```
    @Inject
    private TokenAPI tokenAPI; // 注入

    @GET(produces = "application/xml;charset=UTF-8")
    public Xml test() throws IOException {
        // 获取access token
        tokenAPI.access("wx4518a2295a11c455", "66fffa2d92de182cef37e7f85da2581f").enqueue(new Callback<AccessResult>() {
            public void onResponse(Call<AccessResult> call, Response<AccessResult> response) {
                System.out.println(response.body());
            }

            public void onFailure(Call<AccessResult> call, Throwable throwable) {

            }
        });
        Xml<Object> xml = new Xml<Object>();
        xml.setCode(200);
        xml.setMessage("message");
        xml.setSuccess(true);
        return xml;
    }
```
