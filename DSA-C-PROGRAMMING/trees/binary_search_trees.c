#include<math.h>
#include<stdlib.h>
#include<conio.h>
#include<stdio.h>
#include<limits.h>

/*
    TEST CASE
    12 10 12 30 55 122 3 -10 9 -100 8 199 19
*/

typedef struct binary_search_tree {
    int data;
    struct binary_search_tree *left;
    struct binary_search_tree *right;
} BST;

BST *insert(BST *root, int data) {
    if(root==NULL) {
        BST *newNode = (BST *)malloc(sizeof(BST));
        newNode -> data = data;
        newNode -> right = NULL;
        newNode -> left = NULL;
        return newNode;
    } else {
        if(root->data > data) root->left = insert(root->left, data);
        else root->right = insert(root->right, data);
        return root;
    }
}

int detele_util(BST *root) {
    while(root->left!=NULL) root=root->left;
    return root->data;
}

BST *delete(BST *root, int data) {
    if(root==NULL) return NULL;
    else if(root->data == data) {
        if(root->left==NULL && root->right==NULL) return NULL;
        else if(root->left==NULL) return root->right;
        else if(root->right==NULL) return root->left;
        else {
            root->data=detele_util(root->right);
            root->right=delete(root->right, root->data);
            return root;
        }
    } else {
        if(root->data>data) root->left=delete(root->left, data);
        else root->right=delete(root->right, data);
        return root;
    }
}

void inorder(BST *root) {
    if(root==NULL) return;
    inorder(root->left);
    printf(" %d", root->data);
    inorder(root->right);
}

int max_element(BST *root) {
    if(root==NULL) return -1; // empty tree
    while(root->right!=NULL) root=root->right;
    return root->data;
}

int min_element(BST *root) {
    if(root==NULL) return -1; // empty tree
    while(root->left!=NULL) root=root->left;
    return root->data;
}

int lowest_common_ancestor(BST *root, int a, int b) {
    if(root==NULL) return -1; // empty tree
    else if(root->data>a && root->data>b) return lowest_common_ancestor(root->left, a, b);
    else if(root->data<a && root->data<b) return lowest_common_ancestor(root->right, a, b);
    else return root->data;
}

void print_path_from_root(BST *root, int b) {
    if(root==NULL) return;
    else if(root->data==b) {
        printf(" %d", root->data);
        return;
    } else {
        printf(" %d", root->data);
        if(root->data<b) print_path_from_root(root->right, b);
        else print_path_from_root(root->left, b);
    }
}

void print_path_from_root_reverse(BST *root, int b) {
    if(root==NULL) return;
    else if(root->data==b) {
        printf(" %d", root->data);
        return;
    } else {
        if(root->data<b) print_path_from_root_reverse(root->right, b);
        else print_path_from_root_reverse(root->left, b);
        printf(" %d", root->data);
    }
}

void print_shortest_path(BST *root, int a, int b) {
    if(root==NULL) return;
    else if(root->data>a && root->data>b) return print_shortest_path(root->left, a, b);
    else if(root->data<a && root->data<b) return print_shortest_path(root->right, a, b);
    else if(root->data==a) print_path_from_root(root, b);
    else if(root->data==b) print_path_from_root(root, a);
    else {
        print_path_from_root_reverse(root, a);
        print_path_from_root(root, b);
    }
}

BST *tree_to_DLL(BST *root) {
    if(root==NULL) return NULL;
    BST *left_DLL = tree_to_DLL(root->left);
    BST *right_DLL = tree_to_DLL(root->right);
    if(left_DLL==NULL) root->left=NULL;
    else {
        BST *temp = left_DLL;
        while(temp->right!=NULL) temp=temp->right;
        temp->right=root;
        root->left=temp;
    }
    if(right_DLL==NULL) root->right=NULL; 
    else {
        root->right=right_DLL;
        right_DLL->left=root;
    }
    while(root->left!=NULL) root=root->left;
    return root;
}

int kth_smallest() {
    
}

int floor() {

}

int ceil() {

}

int print_elements_between(int a, int b, BST *root) {

}

BST *trim_tree_in_range(int a, int b, BST *root) {
    
}

int main() {
    int n, temp;
    BST *root=NULL;
    scanf("%d", &n);
    for(int i=0; i<n; i++) {
        scanf("%d", &temp);
        root=insert(root, temp);
    }
    root=delete(root, 3);
    // inorder(root);
    // printf("\n\n");
    // print_shortest_path(root, -100, 55);
    BST *DDL_tree =tree_to_DLL(root);
    BST *prev=DDL_tree;
    while(DDL_tree!=NULL) {
        printf(" %d", DDL_tree->data);
        prev=DDL_tree;
        DDL_tree=DDL_tree->right;
    }
    printf("\n");
    DDL_tree=prev;
    while(DDL_tree!=NULL) {
        printf(" %d", DDL_tree->data);
        DDL_tree=DDL_tree->left;
    }
}