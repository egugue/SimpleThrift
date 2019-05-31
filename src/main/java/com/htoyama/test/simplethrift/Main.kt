package com.htoyama.test.simplethrift

import com.htoyama.test.simplethrift.thrift.Data
import com.htoyama.test.simplethrift.thrift.SimpleService
import com.htoyama.test.simplethrift.thrift.State
import org.apache.thrift.server.TServer
import org.apache.thrift.server.TSimpleServer
import org.apache.thrift.transport.TServerSocket
import java.net.InetAddress
import java.net.InetSocketAddress

fun main() {
  val processor = SimpleService.Processor(SimpleHandler())
  val port = System.getenv("SIMPLE_THRIFT_PORT")?.toIntOrNull() ?: 3001
  val socket = TServerSocket(InetSocketAddress(InetAddress.getLocalHost(), port))
  val server = TSimpleServer(TServer.Args(socket).processor(processor))
  Thread(server::serve).start()
}

class SimpleHandler : SimpleService.Iface {

  override fun findAll(): List<Data> {
    Thread.sleep(1000)
    return listOf(
      Data(1L, "text1", State.Value1).setOptinalText("opText1"),
      Data(2L, "text2", State.Value2),
      Data(3L, "text3", State.Value2)
    )
  }

  override fun store(data: Data) {
    Thread.sleep(3000)
  }
}

