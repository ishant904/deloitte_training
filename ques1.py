#!/usr/bin/env python
# coding: utf-8

# In[16]:


#worst quad calc ever,works only for ax^2+bx+c format with no negative number -_-
import math
stra = eval(input("enter string: "))
#getting all coefficents
lista=stra.split('+')
listb=[]
for i in lista:
    listb.append(i.split('x')[0])
print(listb)
dis=((listb[1]*listb[1])-4*listb[0]*listb[2])
#calculating discriminant
if dis<0:
    a=dis*(-1)
    a=math.sqrt(a)
    a=a/(2*listb[0])
    ae=str(a)+"i"
    be=stra(((-1)*listb[1])/2*listb[0])
    print(ae,'+',be)
    print(ae,'-',be)
elif dis>0:
    ae=math.sqrt(dis)
    print(((-1*)listb[1]+ae)/2*listb[0],(listb[1]-ae)/2*listb[0])
else:
    ae=0
    print((-1*)listb[1]/(2*listb[0]))


# In[14]:


#tried to split with + and - and failed :(
stra = eval(input("enter string: "))
import re
print(re.split('+ | -',stra))


# In[ ]:




