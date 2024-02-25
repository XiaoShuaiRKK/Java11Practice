module AModule {
    //编译和运行时期都可以使用
    exports com.module.a.open;
    //只能在运行时期 通过反射使用
    opens com.module.a.Util;
}