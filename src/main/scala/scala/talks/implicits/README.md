# Implicits

# Types of Implicits 

## Implicit parameters
A method can have an implicit parameter marked by implicit keyword at the start of the parameter list. If the parameters in that parameter list are not passed explicitly, Scala will look if it can get an implicit value of the correct type and if it can, pass it automatically.

## Implicit conversions
Implicit conversion to an expected type is `the first place the compiler will use implicits`. 
Whenever the compiler sees an X, but needs a Y, it will look for an implicit function that converts X to Y. 
For instance, normally a double cannot be used as an integer, because it loses precision:

 ```
 val x: Int = 3.5
   <console>:5: error: type mismatch;
    found   : Double(3.5)
    required: Int
          val x: Int = 3.5
 ```
However, we can define an implicit conversion to cover this: 

```
 implicit def doubleToInt(x: Double) = x.toInt
  doubleToInt: (Double)Int
  
 val i: Int = 3.5
  i: Int = 3
```
What happens here is that the compiler sees a Double, specifically 3.5, in a context where it requires an Int. So the compiler looks at an ordinary type error. 
Before giving up, though, it searches for an implicit conversion from Double to Int. In this case, it finds one: doubleToInt, because doubleToInt is in scope as a single identifier. 
The compiler then inserts a call to doubleToInt automatically. Behind the scenes, the code becomes:
```  
  val i: Int = doubleToInt(3.5)
```
This is literally an implicit conversion. We don't explicitly ask for conversion. 
Instead, we marked `doubleToInt` as an available implicit conversion by bringing it into scope as a single identifier, and then the compiler automatically used it when it needed to convert from a Double to an Int.

## Implicit conversions as implicit parameters
There’s one situation where an implicit is both an implicit conversion and an implicit parameter.
```
 def getIndex[T, CC](seq: CC, value: T)(implicit conv: CC => Seq[T]) = seq.indexOf(value)
 
 getIndex("abc", 'a')
 ```

## Context Bounds
What is Context Bound?
Introduced in Scala 2.8.0. A context Bound describes an implicit value. It is used to declare that for some type A, there’s an implicit value of type B[A] available.

`def f[A: B](a: A) = g(a)   //where g requires an implicit value of type B[A]`
Context bounds are implemented with implicit parameters, given their definition.
## Where does the compiler look for implicits?
1. Implicits Defined in Lexical Scope
2. Implicits Defined in Implicit Scope
3. Companion Objects of a Type
4. Implicit scope of an argument’s type
5. Implicit scope of type arguments
6. Outer Objects for Nested Types
