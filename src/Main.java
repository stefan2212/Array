
class ArrayStructure{

    private int [] array= new int[50];

    private int arraySize=10;

    public void generateRandomArray(){
        for(int i=0; i<arraySize;i++)
            array[i]=(int)(Math.random()*10)+10;
    }

    public void printArray(){
        for(int i=0;i<arraySize;i++)
        {
            System.out.print(" | " + array[i]);
        }
        System.out.println(" | ");
    }

    public int getValueByIndex(int index){
        if( index<arraySize) return array[index];
        return 0;
    }

    public boolean doesItExist(int searchValue){
        for(int i=0;i<arraySize;i++)
            if(array[i]==searchValue)
                return true;
        return false;
    }

    public void deleteIndex(int index){
        if(index < arraySize){
            for(int i=index;i<arraySize -1 ;i++)
                array[i]=array[i+1];
            arraySize--;
        }
        else return;
    }

    public void insertValue(int value){
        if(arraySize<50){
            array[arraySize] = value;
            arraySize++;
        }
    }

    public String linearSearchForValue(int value){
        boolean valueInArray = false;
        String indexWithValue = "";

        for(int i=0;i< arraySize;i++)
            if(array[i]==value)
            {
                valueInArray=true;
                indexWithValue+=i+ " ";
            }
        return indexWithValue;
    }

    public void bubleSort(){
        int sorted=0;
        do{
            sorted=1;
            for(int i=0;i<arraySize-1;i++){
                if(array[i]>array[i+1])
                {
                    sorted=0;
                    swap(i,i+1);
                }
            }
        }while(sorted==0);
    }

    public void selectionSort(){
        for (int x=0;x<arraySize;x++)
        {
            int min=x;
            for(int y=x;y<arraySize;y++)
                if(array[min]>array[y])
                    min=y;
            swap(x,min);
        }
    }

    public void insertionSort(){
        for(int i=1; i<arraySize;i++)
        {
            int j=i;
            int toInsert=array[i];
            while((j>0)&& (array[j-1]>toInsert)){
                array[j]=array[j-1];
                j--;
            }
            array[j]=toInsert;
        }
    }

    public boolean binarySearch(int value){
        int st=0;
        int dr=arraySize-1;

        while(st<=dr){
            int mij=(st+dr)/2;
            if(array[mij]==value)
                return true;
            else if(array[mij]<value)
            {
                st=mij+1;
            }
            else{
                dr=mij-1;
            }
        }
        return false;
    }

    private void swap(int index1, int index2)
    {
        int aux=array[index1];
        array[index1]=array[index2];
        array[index2]=aux;
    }

}

public class Main {

    public static void main(String[] args) {
        ArrayStructure newArray = new ArrayStructure();
        newArray.generateRandomArray();
        newArray.insertionSort();
        newArray.printArray();
        System.out.println(newArray.binarySearch(12));
    }
}
