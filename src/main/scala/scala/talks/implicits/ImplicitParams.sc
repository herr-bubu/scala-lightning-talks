case class PreferredPrompt(text: String)

object Greeter {
  implicit val defaultPrompt: PreferredPrompt = PreferredPrompt("Scala>")
  def greet(name: String)(implicit prompt: PreferredPrompt) = {
    println(s"Welcome, $name\n${prompt.text}")
  }
}

object MyGreeter {
  implicit val myPrompt: PreferredPrompt = PreferredPrompt("Java>")
  def myGreet(name: String) = Greeter.greet(name)
}

import Greeter.defaultPrompt


Greeter.greet("John")

MyGreeter.myGreet("John")
