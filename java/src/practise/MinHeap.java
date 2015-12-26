package practise;

import java.util.Arrays;

public class MinHeap {
	
	public static void main(String...args){
		
		MeanHeapAPI mh = new MeanHeapAPI();
		mh.insert(5);
		mh.insert(3);
		mh.insert(17);
		mh.insert(10);
		mh.insert(84);
		mh.insert(19);
		mh.insert(6);
		mh.insert(22);
		mh.insert(9);
		mh.insert(32);
		mh.insert(15);
		mh.insert(18);
		mh.insert(73);
		
		mh.print_heap();

		mh.deleteMin();


		mh.print_heap();
		
		mh.heapsort();
		
	}
}
	class MeanHeapAPI{
		int[] heaparray = new int[1];
		int last_index=0;
		
		MeanHeapAPI(){
			heaparray[0] = Integer.MAX_VALUE;
		}
		
		public void insert(int k){
			if (last_index < heaparray.length-1){
				heaparray[++last_index] = k;
				int pos = last_index;
				while(parent(pos) != 0 && (heaparray[pos] < heaparray[parent(pos)])){
					swap(pos, parent(pos));
					pos = parent(pos);
				}
			} else {
				double_size();
				insert(k);
			}
			
		}
		
		
		public int deleteMin(){
			int min = heaparray[1];
			heaparray[1] = heaparray[last_index--];
//			size_check();
			mean_heapify();			
			return min;
		}

		public void heapsort(){
			while (last_index > 1){
				int min = deleteMin();
				System.out.print(min + " ");
			}
			System.out.println(heaparray[1]);
			System.out.print('\n');
			
		}


		public void mean_heapify(){
			mean_heapify(1);
		}

		private void mean_heapify(int pos) {
			if (!isLeaf(pos)){
				if (heaparray[pos] > heaparray[left_child(pos)] || heaparray[pos] > heaparray[right_child(pos)]){
					int lc, rc;
					if (left_child(pos) != 0)  {
						lc = heaparray[left_child(pos)];
					} else lc = Integer.MAX_VALUE;
					if (right_child(pos) != 0) {
						rc = heaparray[right_child(pos)];
					} else {
						rc = Integer.MAX_VALUE;
					}
					if (lc < rc ){
						swap(pos, left_child(pos));
						mean_heapify(left_child(pos));
					} else if (lc > rc) {
						swap(pos, right_child(pos));
						mean_heapify(right_child(pos));
					}
				}
			}
			
		}

		public void print_heap(){
			for (int i = 1; i <= last_index; i++){
				System.out.print(heaparray[i] + " ");
			}
			System.out.print('\r');
		}

		private void swap(int pos1, int pos2) {
			int temp = heaparray[pos1];
			heaparray[pos1] = heaparray[pos2];
			heaparray[pos2] = temp; 
		}

		public int parent(int pos){
			return pos/2;
		}
		
		public int left_child(int pos){
			return (2*pos <= last_index) ? 2* pos : 0;
		}
		public int right_child(int pos){
			return (2*pos + 1 <= last_index) ? 2* pos + 1 : 0;		
		}
		public boolean isLeaf(int pos){
			return (pos > (last_index)/2 && pos <= last_index); 
		}
		public void double_size(){
			int[] new_array = new int[2*heaparray.length];
				
			int i;
			for (i = 0; i < heaparray.length; i++){
				new_array[i] = heaparray[i];
			}	
			while(i < new_array.length){
				new_array[i] = Integer.MIN_VALUE;
				i++;
			}
			heaparray = new_array;

			
}
		
		private void size_check() {
			if (last_index < heaparray.length/2){
				int[] new_array = new int[heaparray.length/2];
				for (int i = 0; i <= last_index; i++){
					new_array[i] = heaparray[i];
				}
				heaparray = new_array;
			}
	
		}
		
	}
	
