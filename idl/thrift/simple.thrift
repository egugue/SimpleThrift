namespace java com.htoyama.test.simplethrift.thrift

enum State {
    Value1 = 1
    Value2 = 2
    Value3 = 3
}

struct Data {
    1: i64 id
    2: string text
    3: State state
    4: optional string optinalText
}

service SimpleService {
    list<Data> findAll()

    void store(
        1: required Data data
    )
}
