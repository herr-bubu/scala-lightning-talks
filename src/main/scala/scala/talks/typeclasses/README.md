#Scala Talks

#Types of binding
1. Early Binding
2. Late Binding

#### What is Binding?
Binding means the link between reference and actual code e.g. 
when you refer a variable it's bonded to the code where it is defined, 
similarly when you call a method, it's linked to the code where a method is defined.

#Types of Polymorphism.

                                ------------------------------------------------
                                |                                              |       
                                |              Polymorphism                    |
                                |                                              |
                                ------------------------------------------------ 
                                    /                                       \
                    -----------------------------                       ---------------------------------
                    |                           |                       |                               |
                    |   Ad-hoc Polymorphism     |                       |  Universal Polymorphism       |  
                    |                           |                       |                               |
                    -----------------------------                       ---------------------------------
                        /                     \                                       /               \
               ---------------------    -----------------                    ----------------        -------------------
               |   Overloading/    |    |  Coercion     |                    |  Inclusion   |        | Parametric      |
               |   Overriding      |    | Polymorphism  |                    | Polymorphism |        | Polymorphism    |
               ---------------------    -----------------                    ----------------        -------------------
                     /          \             /         \                       /          \                  |
          ------------   ------------   ------------  -------------    -------------  -----------------     ------------   
          | Operator |   | Function |   | Widening |  | Narrowing |    | Covariant |  | Contravariant |     | Generics |
          ------------   ------------   ------------  -------------    -------------  -----------------     ------------

1. `Parametric Polymorphism`
A way to make a language more expressive, while still maintaining full static type-safety. 
Using parametric polymorphism, a function or a data type can be written generically so that it can handle values identically without depending on their type. 
Such functions and data types are called generic functions and generic data types respectively and form the basis of generic programming.
In short: It's just another term for "Generics" in Java.
2. `Ad-hoc Polymorphism`
Ad-hoc polymorphism, by contrast, allows a polymorphic value to exhibit different behaviors when “viewed” at different types. 
The most common example of ad-hoc polymorphism is overloading, which associates a single function symbol with many implementations; 
the compiler (or the runtime system, depending on whether overloading resolution is static or dynamic) chooses an appropriate implementation for each application of the function, based on the types of the arguments.
####Overloading
```
def add(s1: String, s2: String): String = s1 + s2

def add(x1: Int, x2: Int): Int = x1 + x2    
```

##Limits of Subtyping.

//TODO

## Type classes - Theory.
A `type class` is a sort of interface that defines some behaviour. 
If a type is part of type class, that means it supports and implements the behaviour the typeclass describes.
Those coming from OOP get confused by typeclasses because they tend to think of them as classes in Object Oriented Programming.
We can think of them as Java interfaces, only better. They originally come from Haskell.
Type classes are a powerful feature of Scala.

##Type Class Pattern in Scala.