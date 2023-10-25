#include<math.h>
#include<stdlib.h>
#include<conio.h>
#include<stdio.h>
#include<limits.h>

/*
    Test Tree : 10 75 -1 18 16 20 -1 -1 19 -1 -1 -1 35 -1 48 -1 65 80 -1 70 -1 -1 11 -1 -1
*/

typedef struct tree_node {
    int data;
    struct tree_node *left;
    struct tree_node *right;
} tree_node;

//--------------------------------------------------------------------------------------------------------------//
typedef struct node {
    tree_node *data;
    struct node *next;
} node;

// STACK FOR TREE
void push(node **head, tree_node *value) {
    if(*head == NULL) {
        *head = (node *) malloc(sizeof(node));
        (*head) -> next = NULL;
        (*head) -> data = value;
    } else {
        node *newNode = (node *)malloc(sizeof(node));
        newNode -> data = value;
        newNode -> next = *head;
        *head = newNode;
    }
}

tree_node *pop(node **head) {
    if(*head==NULL) return NULL;
    else {
        node *temp = (*head);
        *head = (*head) -> next;
        return temp->data;
    }
}

tree_node *peek(node **head) {
    if((*head)==NULL) return NULL;
    else return (*head)->data;
}

int isEmpty(node **head) {
    if((*head)==NULL) return 1;
    else return 0;
}

void print_stack(node **head) {
    node *temp = *head;
    printf("\nStack : ");
    while(temp != NULL) {
        printf(" %d", temp -> data -> data);
        temp = temp -> next;
    }
}

// QUEUE FOR TREE
void enqueue(node **head, tree_node *root) {
    if(*head == NULL) {
        node *newNode = (node *)malloc(sizeof(node));
        newNode -> data = root;
        newNode -> next = NULL;
        *head = newNode;
    } else {
        node *temp = (*head);
        while(temp->next != NULL) {
            temp = temp ->next;
        } temp -> next = (node *)malloc(sizeof(node));
        temp -> next -> data = root;
        temp -> next -> next = NULL;
    }
}

tree_node *dequeue(node **head) {
    if(*head == NULL) return NULL;
    else {
        node *temp = (*head);
        (*head) = (*head) -> next;
        return temp -> data;
    }
}

/* PEEK function remains the same as stack*/

void print_queue(node ** head) {
    node *temp = (*head);
    printf("\nQueue : ");
    while(temp!=NULL) {
        printf(" %d", temp->data->data);
        temp = temp -> next;
    }
}


// Util Functions

int int_max(int a, int b) {
    return a > b ? a : b;
}

int int_min(int a, int b) {
    return a < b ? a : b;
}

tree_node *get_null_node() {
    tree_node *root = (tree_node *)malloc(sizeof(tree_node));
    root -> data = -1;
    root -> right = NULL;
    root -> left = NULL;
}

//--------------------------------------------------------------------------------------------------------------//

tree_node *input_binary_tree_preorder() {
    int value = -1;
    scanf("%d", &value);
    if(value == -1) return NULL;
    tree_node *newNode = (tree_node *)malloc(sizeof(tree_node));
    newNode -> data = value;
    printf("\nEnter Left of    : %3d", newNode -> data);
    newNode -> left = input_binary_tree_preorder();
    printf("\nEnter Right of   : %3d", newNode -> data);
    newNode -> right = input_binary_tree_preorder();
}

void inorder(tree_node *root) {
    tree_node *temp = root;
    node *stack = NULL;
    while(temp != NULL) {
        push(&stack, temp);
        temp = temp -> left;
    }

    while(isEmpty(&stack)==0) {
        temp = pop(&stack);
        printf(" %d", temp->data);
        temp = temp -> right;
        while(temp != NULL) {
            push(&stack, temp);
            temp = temp -> left;
        }
    }
}

void preorder(tree_node *root) {
    tree_node *temp = root;
    node *stack = NULL;
    while(temp!=NULL) {
        push(&stack, temp);
        printf(" %d", temp -> data);
        temp = temp->left;
    }

    while(isEmpty(&stack)==0) {
        temp = pop(&stack);
        temp = temp -> right;
        while(temp!=NULL) {
            push(&stack, temp);
            printf(" %d", temp -> data);
            temp = temp -> left;
        }
    }
}

void postorder(tree_node *root) {
    tree_node *temp = root;
    node *stack = NULL;
    while(temp != NULL) {
        push(&stack, temp);
        temp = temp -> left;
    }
    tree_node *prev=NULL;
    while(isEmpty(&stack)==0) {
        temp = peek(&stack);
        if(temp -> right == NULL) {
            printf(" %d", temp -> data);
            prev = pop(&stack);
        } else if(temp -> right == prev) {
            printf(" %d", temp -> data);
            prev = pop(&stack);
        } else {
            temp = temp -> right;
            while(temp != NULL) {
                push(&stack, temp);
                temp = temp -> left;
            }
        }
    }
}

void level_order(tree_node *root) {
    node *queue = NULL;
    enqueue(&queue, root);
    while(isEmpty(&queue)==0) {
        tree_node *temp = dequeue(&queue);
        printf(" %d", temp -> data);
        if(temp->left != NULL) enqueue(&queue, temp->left);
        if(temp->right != NULL) enqueue(&queue, temp->right);
    }
}

void verticle_order() {

}

void left_view(tree_node *root) {
    node *queue = NULL;
    enqueue(&queue, get_null_node());
    enqueue(&queue, root);
    while(isEmpty(&queue)==0) {
        tree_node *temp = dequeue(&queue);
        if(temp->data == -1) {
            if(isEmpty(&queue)==1) break;
            else {
                enqueue(&queue, get_null_node());
                temp = dequeue(&queue);
                printf(" %d", temp -> data);
            }
        }
        if(temp->left != NULL) enqueue(&queue, temp->left);
        if(temp->right != NULL) enqueue(&queue, temp->right);
    }
}

void right_view(tree_node *root) {
    node *queue = NULL;
    enqueue(&queue, root);
    enqueue(&queue, get_null_node());
    while(isEmpty(&queue)==0) {
        tree_node *temp = dequeue(&queue);
        if(temp->data == -1) {
            if(isEmpty(&queue)==1) break;
            else {
                enqueue(&queue, get_null_node());
                temp = dequeue(&queue);
            }
        }
        if(peek(&queue)->data == -1) {
            printf(" %d", temp -> data);
        }
        if(temp->left != NULL) enqueue(&queue, temp->left);
        if(temp->right != NULL) enqueue(&queue, temp->right);
    }
}

int height_recursive(tree_node *root) {
    if(root == NULL) return 0;
    else return int_max(height_recursive(root->left), height_recursive(root->right)) + 1;
}

void height_non_recursive() {

}

int get_max_recursive(tree_node *root) {
    // gives min int value if root is null
    if(root==NULL) return INT_MIN;
    else return int_max(root -> data, int_max(get_max_recursive(root->left), get_max_recursive(root->right)));
}

void get_max_non_recursive() {

}

int get_min_recursive(tree_node *root) {
    // gives max int value if root is null
    if(root==NULL) return INT_MAX;
    else return int_min(root -> data, int_min(get_min_recursive(root->left), get_min_recursive(root->right)));
}

void get_min_non_recursive() {

}

int search_recursive(tree_node *root, int value) {
    // 0 if not present, 1 if present
    if(root==NULL) return 0;
    else if(root -> data == value) return 1;
    else search_recursive(root->left, value) | search_recursive(root->right, value);
}

void search_non_recursive() {

}

void insert_recursive() {

}

void insert_non_recursive() {

}

int size_recursive(tree_node *root) {
    if(root == NULL) return 0;
    else return 1 + size_recursive(root->left) + size_recursive(root->right);
}

void size_non_recursive() {

}

void reverse_level_order() {

}

void delete_tree() {

}

void get_deepest_node() {

}

void leaf_node_count_recursive() {

}

void leaf_node_count_non_recursive() {

}

void full_node_count_recursive() {
    
}

void full_node_count_non_recursive() {

}

void half_node_count_recursive() {
    
}

void half_node_count_non_recursive() {

}

void have_same_structure(/*given two trees*/) {

}

void diameter() {

}

void max_sum_in_level() {

}

void print_all_paths_to_leaf() {
    // print all paths from root to all leaf nodes in O(N)
}

void have_path_with_sum() {
    // check if any path has sum of ele = given sum, path from root to leaf obviously.
}

void sum_recursive() {

}

void sum_non_recursive() {

}

void get_mirror() {
    // given a tree, return its mirror tree
}

void check_if_mirror() {

}

void get_least_common_ancestor() {
    // given two nodes
}

void create_binary_tree_from_IN_PRE() {
    // given inorder and preorder
}

void create_binary_tree_from_IN_POST() {
    // given inorder and postorder
}

void print_all_ancestors() {
    // given a node
}

void zig_zag_order() {

}

void verticle_sum() {
    // sum of every verticle level
}

int main() {
    printf("Enter Root Element : (-1 = NULL) : ");
    tree_node *root = input_binary_tree_preorder();
    system("cls");
    
    printf("Height of Tree : %d\n", height_recursive(root));
    
    printf("Inorder Traversal : ");
    inorder(root);
    printf("\n");
    printf("Preorder Traversal : ");
    preorder(root);
    printf("\n");
    printf("Postorder Traversal : ");
    postorder(root);
    printf("\n");
    printf("LevelOrder Traversal : ");
    level_order(root);
    printf("\n");
    printf("Left view : ");
    left_view(root);
    printf("\n");
    printf("Right view : ");
    right_view(root);
    printf("\n");

    printf("\ndone");
}