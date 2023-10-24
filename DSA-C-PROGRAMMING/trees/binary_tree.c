#include<stdlib.h>
#include<conio.h>
#include<stdio.h>

/*
    Test Tree : 10 75 -1 18 16 20 -1 -1 19 -1 -1 -1 35 -1 48 -1 65 80 -1 70 -1 -1 11 -1 -1
*/

typedef struct tree_node {
    int data;
    struct tree_node *left;
    struct tree_node *right;
} tree_node;

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

void inorder() {

}

void preorder() {

}

void postorder() {

}

void level_order() {

}

void verticle_order() {

}

void left_view() {

}

void right_view() {

}

void height_recursive() {

}

void height_non_recursive() {

}

void get_max_recursive() {

}

void get_max_non_recursive() {

}

void get_min_recursive() {

}

void get_min_non_recursive() {

}

void search_recursive() {

}

void search_non_recursive() {

}

void insert_recursive() {

}

void insert_non_recursive() {

}

void size_recursive() {

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
}