#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<math.h>

typedef struct AVL_TREE {
    int data;
    int height;
    struct AVL_TREE *left;
    struct AVL_TREE *right;
} AVL;

int get_height(AVL *root) {
    // O(1) complexity - constant ops
    if(root==NULL) return 0;
    int left_height = 0;
    int right_height = 0;
    if(root -> left != NULL) left_height = (root -> left) -> height;
    if(root -> right != NULL) right_height = (root -> right) ->height;
    return (((left_height) > (right_height)) ? (left_height) : (right_height)) + 1;
}

AVL *rotate_right(AVL *root) {
    AVL *temp = root->left->right;
    root->left->right = root;
    root = root->left;
    root->right->left = temp;
    return root;
}

AVL *rotate_left(AVL *root) {
    AVL *temp = root->right->left;
    root->right->left = root;
    root = root->right;
    root->left->right = temp;
    return root;
}

AVL *insert_AVL(AVL *root, int data) {
    if(root == NULL) {
        AVL *newNode = (AVL *)malloc(sizeof(AVL));
        newNode -> left = NULL;
        newNode -> right = NULL;
        newNode -> data = data;
        newNode -> height = 1;
        return newNode;
    } else {
        if(root->data > data) {
            root->left = insert_AVL(root->left, data);
        } else {
            root->right = insert_AVL(root->right, data);
        }
        root -> height = get_height(root);
        int left_height = get_height(root->left);
        int right_height = get_height(root->right);
        int balance_factor = right_height - left_height;
        if(balance_factor < -1) {
            if(root->left->data > data) {
                // LL insertion
                root = rotate_right(root);
                root -> right -> height = get_height(root->right);
                root -> height = get_height(root);
            } else {
                // LR insertion
                root -> left = rotate_left(root);
                root -> left -> left -> height = get_height(root -> left -> left);
                root -> left -> height = get_height(root -> left);
                
                root = rotate_right(root);
                root -> right -> height = get_height(root->right);
                root -> height = get_height(root);
            }
        } else if(balance_factor > 1) {
            if(root->right->data < data) {
                // RR insertion
                root = rotate_left(root);
                root -> left -> height = get_height(root->left);
                root -> height = get_height(root);
            } else {
                // RL insertion
                root -> right = rotate_right(root->right);
                root -> right -> right -> height = get_height(root->right);
                root -> right -> height = get_height(root->right);

                root = rotate_left(root);
                root -> left -> height = get_height(root->left);
                root -> height = get_height(root);
            }
        }
        return root;
    }
}

void preorder(AVL *root) {
    if(root==NULL) return;
    else {
        printf("\n%d - load_factor : %d", root->data, get_height(root->right)-get_height(root->left));
        preorder(root->left);
        preorder(root->right);
    }
}

void inorder(AVL *root) {
    if(root==NULL) return;
    else {
        inorder(root->left);
        printf("\n%d - load_factor : %d", root->data, get_height(root->right)-get_height(root->left));
        inorder(root->right);
    }
}

void postorder(AVL *root) {
    if(root==NULL) return;
    else {
        postorder(root->left);
        postorder(root->right);
        printf("\n%d - load_factor : %d", root->data, get_height(root->right)-get_height(root->left));
    }
}

int main() {
    // TEST CASE : 12 10 12 30 55 122 3 -10 9 -100 8 199 19
    AVL *root = NULL;
    int n;
    printf("Enter the Size of tree (no. of nodes) : ");
    scanf("%d", &n);
    for(int i=0; i<n; i++) {
        int temp = 0;
        scanf("%d", &temp);
        root = insert_AVL(root, temp);
        printf(" %d", temp);
    }
    printf("\n\nINORDER : ");
    inorder(root);
    printf("\n\nPREORDER : ");
    preorder(root);
    printf("\n\nPOSTORDER : ");
    postorder(root);
}