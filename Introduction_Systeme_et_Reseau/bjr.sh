clear
for f in *
do
	if [ -f $f ]
	then
	
		for x in $*
		do 
		n=`grep -ci $x $f`

			if (( n>0 ))
			then

				mv $f ~/Documents/Programmation/DUMP
			fi		
		done
	fi
done
