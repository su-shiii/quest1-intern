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

#ensuring only 5 mopokens are used:
if len(your_mopokens)!=5 or len(opp_mopokens)!=5:
    print("Each player must have exactly 5 mopokens.")
    exit()

#ensuring only 5 mopokens are used:
you_unique=[]
opp_unique=[]
for a, b in zip(your_mopokens, opp_mopokens):
    if a[0] not in you_unique:
        you_unique.append(a[0])
    if b[0] not in opp_unique:
        opp_unique.append(b[0])
if len(you_unique)!=5 or len(opp_unique)!=5:
    print("Each player must have 5 unique mopokens.")
    exit()



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
me_used=[False]*len(your_mopokens)
them_used=[False]*len(opp_mopokens)

#list to track the order of your mopokens used
me_order=[]
they_order=[]

wins=0

#loop thru my mopokens
for i in range(len(your_mopokens)):
    #list of types my current mopoken can defeat
    defeat=type_inv[your_mopokens[i][0]]
    for j in range(len(opp_mopokens)):
        if opp_mopokens[j][0] in defeat and them_used[j]==False:
            if (2*opp_mopokens[j][1])>= your_mopokens[i][1]:
                continue
            else:
                me_used[i]=True
                them_used[j]=True
                me_order.append(your_mopokens[i])
                they_order.append(opp_mopokens[j])
                wins+=1
                break
    for k in range(len(opp_mopokens)):
        if me_used[i]==True:
            continue
        else:
            if them_used[k]==False:
                if your_mopokens[i][1]>opp_mopokens[k][1]:
                    me_used[i]=True
                    them_used[k]=True
                    me_order.append(your_mopokens[i])
                    they_order.append(opp_mopokens[k])
                    wins+=1
                    break
    
if wins>=3:
    print("You win the battle! You have advantage in {wins} out of 5 matches.".format(wins=wins))

ch=input("Do you want to see the battle details? (y/n):")
if ch in 'yY':
    print("Battle Details:")
    for a,b in zip(me_order,they_order):
        print("Your {a[0]} (lvl{a[1]}) won over opponent's {b[0]} (lvl{b[1]})".format (a=a,b=b))

        

