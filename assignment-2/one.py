ip=input("Enter your mopokens:")
your_mopokens=[]
m=ip.split(';')
for i in m:
    sub=i.split("#")
    your_mopokens.append([sub[0],int(sub[1])])
print(your_mopokens) 
    
ip2=input("Enter opponent's mopokens:")
opp_mopokens=[]
m2=ip2.split(';')
for i in m2:
    sub=i.split("#")
    opp_mopokens.append([sub[0],int(sub[1])])
print(opp_mopokens) 


#dict for type advantages
type_rules={ #a: defeats b
    "Fire": ["Grass", "Ghost"],
    "Water": ["Fire"],
    "Grass": ["Electric", "Fighting"],
    "Electric": ["Water"],
    "Psychic": ["Ghost"],
    "Ghost": ["Fighting", "Fire", "Electric"],
    "Fighting": ["Electric"]
}

type_inv= { #a: gets defeated by b
    "Fire": ["Water", "Ghost"],
    "Water": ["Electric"],
    "Grass": ["Fire"],
    "Electric": ["Grass", "Ghost", "Fighting"],
    "Psychic": [],
    "Ghost": ["Fire", "Psychic"],
    "Fighting": ["Grass", "Ghost"]
}

#empty list to track which of your mopokens have been used.
used=[False]*len(your_mopokens)
order=[]
wins=0
opp_used=[]



#loop thru opponents first then loop thru your mopokens
for i in range(len(opp_mopokens)):
    match=False
    opp_type=opp_mopokens[i][0]
    opp_level=opp_mopokens[i][1]
    defeat=type_inv[opp_type]
    for j in range(len(your_mopokens)):
        if your_mopokens[j][0] in defeat and used[j]==False:
            if (2*your_mopokens[j][1])<=(opp_mopokens[i][1]):
                continue
            else:
                used[j]=True
                order.append(j)
                opp_used.append(opp_mopokens[j])
                wins+=1
                break
    if used[i]==False:
        for k in opp_mopokens:
            if k not in opp_used:
                used[i]=True
                order.append(i)
                opp_used.append(opp_mopokens[i])
                break



#ok so the type logic is done, now just the level comparisons. put it inside rge diuble loop and inside condition ig
print("Pokemon used in order:", order)
print("Total wins:", wins)