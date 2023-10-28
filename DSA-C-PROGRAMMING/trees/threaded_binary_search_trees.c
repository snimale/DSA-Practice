#include<conio.h>
#include<stdlib.h>
#include<stdio.h>
#include<math.h>

/*
    
    Test case : 
    13 100 77 200 55 88 83 202 302 404 110 101 109 105

*/

typedef struct threaded_binary_search_tree_node {
    int data;
    int leftIsThread;
    int rightIsThread;
    struct threaded_binary_search_tree_node *left;
    struct threaded_binary_search_tree_node *right;
} TBST_Node;

void insert(TBST_Node *head, int data) {
    if(head -> leftIsThread) {
        // first node
        head->leftIsThread=0;
        TBST_Node * newNode = (TBST_Node *)malloc(sizeof(TBST_Node));
        newNode -> data = data;
        newNode -> left = head;
        newNode -> leftIsThread = 1;
        newNode -> right = head;
        newNode -> rightIsThread = 1;
        head->left = newNode;
    } else {
        TBST_Node *root = head -> left;
        while(1) {
            if(root->data > data && root->leftIsThread==0) root=root->left;
            else if(root->data < data && root->rightIsThread==0) root=root->right;
            else break; // reached leaf node
        }

        TBST_Node *newNode = (TBST_Node *)malloc(sizeof(TBST_Node));
        newNode -> data = data;

        if(root->data > data) {
            newNode -> rightIsThread = 1;
            newNode -> leftIsThread = 1;
            newNode -> right = root;
            newNode -> left = root -> left;

            root -> left = newNode;
            root -> leftIsThread = 0; 
        } else {
            newNode -> rightIsThread = 1;
            newNode -> leftIsThread = 1;
            newNode -> left = root;
            newNode -> right = root -> right;

            root -> right = newNode;
            root -> rightIsThread = 0;
        }
    }
}

void inorder_TBT(TBST_Node *head) {
    if(head -> leftIsThread == 1) return;
    else {
        TBST_Node *root = head->left;
        while(root->leftIsThread==0) {
            root = root->left;
        } printf("\nINORDER TBT TRAVERSAL : ");
        while(root!=head) {
            printf(" %d", root->data);
            if(root->rightIsThread) root=root->right;
            else {
                root=root->right;
                while(root->leftIsThread==0) {
                    root=root->left;
                } 
            }
        }
    }
}

int main() {
    TBST_Node *head = (TBST_Node *)malloc(sizeof(TBST_Node));
    head -> data = -1;
    head -> leftIsThread = 1;
    head -> rightIsThread = 1;
    head -> left = head;
    head -> right = head;

    int n = 0;
    printf("Enter Number of Elements : ");
    scanf("%d", &n);
    printf("Enter the %d Elements : ", n);
    for(int i=0; i<n; i++) {
        int temp = 0;
        scanf("%d", &temp);
        insert(head, temp);
    }

    inorder_TBT(head);
}