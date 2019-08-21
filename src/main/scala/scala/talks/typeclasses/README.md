#Scala Talks

#Binding
#### What is Binding?
Binding means the link between reference and actual code e.g. 
when you refer a variable it's bounded to the code where it is defined, 
similarly when you call a method, it's linked to the code where a method is defined.

####Types of binding
1. Early Binding
2. Late Binding

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
2. `Includion Polymorphism`
Inclusion polymorphism achieves polymorphic behavior through an inclusion relation between types or sets of values. 
For many object-oriented languages, including Java, the inclusion relation is a subtype relation. So in Java, inclusion polymorphism is subtype polymorphism.
3. `Coercion Polymorphism`
Coercion represents implicit parameter type conversion to the type expected by a method or an operator, thereby avoiding type errors.
4. `Ad-hoc Polymorphism`
Ad-hoc polymorphism, by contrast, allows a polymorphic value to exhibit different behaviors when “viewed” at different types. 
The most common example of ad-hoc polymorphism is overloading, which associates a single function symbol with many implementations; 
the compiler (or the runtime system, depending on whether overloading resolution is static or dynamic) chooses an appropriate implementation for each application of the function, based on the types of the arguments.
####Operator Overloading
```
class Complex { 
private: 
    int real, imag; 
public: 
    Complex(int r = 0, int i =0)  {real = r;   imag = i;} 
       
    Complex operator + (Complex const &obj) { 
         Complex res; 
         res.real = real + obj.real; 
         res.imag = imag + obj.imag; 
         return res; 
    } 
    void print() { cout << real << " + i" << imag << endl; } 
}; 
  
int main() 
{ 
    Complex c1(10, 5), c2(2, 4); 
    Complex c3 = c1 + c2; 
    c3.print(); 
} 
```
####Function Overloading
```
def add(s1: String, s2: String): String = s1 + s2

def add(x1: Int, x2: Int): Int = x1 + x2    
```

##Limits of Subtyping.

What we need is a generic function parametrised for different types. So let's introduce type parameter:

```
    def add[T](x1: T, x2: T): T = ???
```
But how can we implement it?
It would be nicer to have a kind of type that supports this operation. We could for instance define such a type: `Addable`.
```
    trait Addable[T] {
        def add(other: T): T
    }
```
and then use it as:
```
    def add[T <: Addable[A]](x1: T, x2: T): T = x.add(y) 
```
Here we're using `Upper Bound` clause to accept only subtypes of `Addable` trait.

But what with `Integer` or `String`? We cannot make them subtypes of `Addable`.

## Type classes - Theory.
A `type class` is a sort of interface that defines some behaviour. 
If a type is part of type class, that means it supports and implements the behaviour the typeclass describes.
Those coming from OOP get confused by typeclasses because they tend to think of them as classes in Object Oriented Programming.
We can think of them as Java interfaces, only better. They originally come from Haskell.
Type classes are a powerful feature of Scala but Scala itself doesn't have any native support for type classes.

##Type Class Pattern in Scala.

Let's go back to the beginning. We have a signature like: 
```
    def add[T](x1: T, x2: T): T = ???
```

and assume we have a trait:
```
    trait Adder[T] {
        def add(x1: T, x2: T): T  
    }
```