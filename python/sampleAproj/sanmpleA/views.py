from django.http import HttpResponse
from django.shortcuts import render
def home(requests):
    return render(requests,'index.html',{'city':['hyd','bang']})
def count(requests):
    data=requests.GET['name']
    listw=data.split()
    wordict={}
    for word in listw:
        if word in wordict:
            wordict[word]+=1
        else:
            wordict[word]=1


    sorted(wordict.items(),key=lambda wd:(wd[1], wd[0]));
    return render(requests,'count.html',{'dataone':data,'len':len(listw),'wordict':wordict.items()})
