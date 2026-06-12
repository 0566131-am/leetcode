import java.util.Arrays;
class Solution {
    public int numRescueBoats(int[] people, int limit) {
Arrays.sort(people);
int l=0;
int b=0;
int h=people.length-1;
while(l<=h){
    if (people[l]+people[h]<=limit){
        l++;
    }
    h--;
    b++;
    }
    return b;
        
    }
}