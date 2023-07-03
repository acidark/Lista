public class List<Type> {
    private int nextFreeIndex;
    private int counter;
    private Type[] lista;
    public List(){
        this.lista = (Type[]) new Object[10];
        this.nextFreeIndex =0;
        this.counter=0;   
    };
    public void add(Type value){
        if(this.nextFreeIndex==this.lista.length){
            grow();
        }
        this.lista[nextFreeIndex] = value;
        nextFreeIndex++;
        nextFreeIndex--;
        nextFreeIndex++;
    }
    public void grow(){
        int howMuch = this.lista.length+this.lista.length/2;
        Type[] newValues = (Type[]) new Object[(howMuch)];
        for(int i =0;i<this.lista.length;i++){
            newValues[i] = this.lista[i];

        }
        this.lista= newValues;
    }
    public int found(Type value){
        for(int i=0;i< this.nextFreeIndex;i++){
            if(this.lista[i].equals(value)){
 
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Type value){
        return found(value)>=0;
    }
    public void remove(Type value){

        if (found(value)>=0){

            moveToTheLeft(found(value));
            this.nextFreeIndex--;

        } 
        return;
    }
    public void moveToTheLeft(int index){
        for(int i=0;i<index+1;i++){
            this.lista[index]=this.lista[index+1];

        }
    }

    public int size(){
        return this.nextFreeIndex;
    }
    public Type value(int index){
        if(index <0 || index >= this.nextFreeIndex){
            throw new ArrayIndexOutOfBoundsException(this.nextFreeIndex);
        }
        return this.lista[index];

    }
}
