clear
cd $1
for f in *
do
	if [[ $f =~ .*$2$ ]] #~ = expr. reguliere
	then
		mv $f ~/Documents/Programmation/DUMP
	fi		
done