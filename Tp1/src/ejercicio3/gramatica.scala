

package ejercicio3

import com.sun.nio.sctp.IllegalReceiveException

object gramatica 
{
  val input = scala.collection.mutable.MutableList('(','(','i','d',')',')')
  val caracterActual=new StringBuilder
  
  def main(args: Array[String]): Unit = 
  {
    
   
    

    SiguienteCaracter()
   
    S()
    
      if (caracterActual.length!=0 && input.length==0)
     {
       throw new IllegalReceiveException
     }
      else
        print ("Tudo bom tudo legal")
   
    
   
  }

  private def matcheo(caracter: Char): Unit=
  {
    
    
    if(caracterActual.length!=0 && caracterActual.charAt(0)==caracter )
    {
     
      SiguienteCaracter()
    }
    else
    {
      throw new IllegalReceiveException
    }
    
  }
  
  def SiguienteCaracter(): Unit=
  {

    if (input.length!=0)
    {
       caracterActual.clear()
       caracterActual.insert(0, input.apply(0))
      val auxiliar=removeIndex(input, 0)
      input.clear()
      input.++=(auxiliar)
    }
    else
    {
      caracterActual.clear()
    }
   
    
     
    
    
    
    
   
      
   }
    
  def removeIndex[A](s: Seq[A], n: Int): Seq[A] = s.indices.collect
  { 
    case i if i != n => s(i) }
  
  def S()
  {
    T()
    A()
   

  
  }
  
  def T()
  {
    F()
    B()
  }
  
  def A()
  {
    if(caracterActual.length!=0 && caracterActual.charAt(0)=='+')
    {
      matcheo('+')
      T()
      A()
    }
    
    
   
    
  }
  
  def B()
  {
    if(caracterActual.length!=0 && caracterActual.charAt(0)=='*')
    {
      matcheo('*')
      F()
      B()
    }
  }
  
  def F()
  {
    
    
    if(caracterActual.length!=0 && caracterActual.charAt(0)=='(')
    {
     
      matcheo('(')
      
      S()
      
      matcheo(')')
    }
    else 
    {
     
      matcheo('i')
      matcheo('d')
      
    }
    
  }
  
 
}