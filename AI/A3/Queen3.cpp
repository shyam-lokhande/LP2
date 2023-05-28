#include<iostream>
#include<vector>

using namespace std;

bool isSafe(vector<vector<int>>& board,int row,int col,int n){
    for(int i=0;i<row;i++){
        if(board[i][col]==1) return false;
    }
    for(int i=row,j=col;i>=0 && j>=0;i--,j--){
        if(board[i][j]==1) return false;
    }
    for(int i=row,j=col;i>=0 && j<=n;j++,i--){
        if(board[i][j]==1) return false;
    }
    return true;
}

void solveNQueens(vector<vector<int>>& board,int row,int n,vector<vector<vector<int>>>& solutions){
    if(row==n){
        solutions.push_back(board);
        return;
    }

    for(int col=0;col<n;col++){
        if(isSafe(board,row,col,n)){
            board[row][col]=1;
            solveNQueens(board,row+1,n,solutions);
            board[row][col]=0;
        }
    }
}

void printSolutions(vector<vector<vector<int>>>& solutions){
    int num_sol=solutions.size(),bsize=solutions[0].size();
    for(int i=0;i<num_sol;i++){
        cout<<"Solution : "<<i<<endl;
        for(int j=0;j<bsize;j++){
            for(int k=0;k<bsize;k++){
                cout<<solutions[i][j][k]<<" ";
            }
            cout<<endl;
        }
        cout<<endl;
    }
}

int main(){
    cout<<"Enter the size of the board : ";
    int n;
    cin>>n;

    vector<vector<int>> board(n,vector<int>(n,0));
    vector<vector<vector<int>>> solutions;

    solveNQueens(board,0,n,solutions);

    printSolutions(solutions);
}