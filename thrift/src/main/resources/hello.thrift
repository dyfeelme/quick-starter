namespace java com.zs.framework.thrift
service HelloService{
    string sayName(1:string name)
    i32 sayAge(1:i32 age)
    bool isHappy(1:bool happy)
    void sayVoid()
    string sayNull()
}

