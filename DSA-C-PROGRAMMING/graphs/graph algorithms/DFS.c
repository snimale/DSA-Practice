#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define bool int

//----------------------------------------- STACK IMPLEMENTATION START -----------------------------------------//

typedef struct stack_node {
    int data;
    struct stack_node *next;
} stack;

void push(stack **s, int data) {
    if (*s == NULL) {
        stack *newStack = (stack *)malloc(sizeof(stack));
        newStack -> data = data;
        newStack -> next = NULL;
        *s = newStack;
    } else {
        stack *temp = *s;
        stack *newStack = (stack *)malloc(sizeof(stack));
        newStack -> data = data;
        newStack -> next = temp;
        *s = newStack;
    }
}

int pop(stack **s) {
    if(*s == NULL) return -1;
    else {
        int data = (*s)->data;
        *s = (*s)->next;
        return data;
    }
}

int peek(stack **s) {
    if(*s == NULL) return -1;
    else return (*s)->data;
}

int isEmpty(stack **s) {
    if(*s == NULL) return 1;
    else return 0;
}

//----------------------------------------- STACK IMPLEMENTATION END -------------------------------------------//


typedef struct graph_AM {
    int vertex_count;
    int **graph;
} graph_AM;

typedef struct Node {
    int vertex;
    struct Node *next;
} Node;

typedef struct graph_AL {
    int vertex_count;
    struct Node **graph;
} graph_AL;


void init_graph(graph_AL *, graph_AM *, int);
void get_input_graph(graph_AL *, graph_AM *, int);
void print_adjacency_list(graph_AL *);
void print_adjacency_matrix(graph_AM *);
void dfs_adjacency_list_non_recursive(graph_AL *);
void dfs_adjacency_list_recursive(graph_AL *, int , int *);
void dfs_adjacency_matrix_non_recursive(graph_AM *);
void dfs_adjacency_matrix_recursive(graph_AM *, int , int *);

int main() {
    graph_AL graph1; graph_AM graph2;
    int vertex_count=0, edge_count=0;
    
    printf("Enter vertex count : ");
    scanf("%d", &vertex_count);
    init_graph(&graph1, &graph2, vertex_count);

    printf("Enter edge count : ");
    scanf("%d", &edge_count);
    get_input_graph(&graph1, &graph2, edge_count);

    print_adjacency_list(&graph1);
    dfs_adjacency_list_non_recursive(&graph1);
    int *visited = (int *)calloc(graph2.vertex_count, sizeof(int));
    visited[0]=1;
    printf("\nDFS ADJACENCY LIST, RECURSIVE : \n");
    dfs_adjacency_list_recursive(&graph1, 0, visited);

    printf("\n");
    print_adjacency_matrix(&graph2);
    dfs_adjacency_matrix_non_recursive(&graph2);
    visited = (int *)calloc(graph2.vertex_count, sizeof(int));
    visited[0]=1;
    printf("\nDFS ADJACENCY MATRIX, RECURSIVE : \n");
    dfs_adjacency_matrix_recursive(&graph2, 0, visited);
}

void init_graph(graph_AL *graph1, graph_AM *graph2, int vertex_count) {
    graph1->vertex_count = vertex_count;
    graph2->vertex_count = vertex_count;
    
    graph1->graph = (Node **)malloc(sizeof(Node *)*vertex_count);
    for(int i=0; i<vertex_count; i++) {
        graph1->graph[i] = (Node *)malloc(sizeof(Node));
        graph1->graph[i] -> vertex = i;
        graph1->graph[i] -> next = NULL;
    }

    graph2->graph = (int **)malloc(sizeof(int *)*vertex_count);
    for(int i=0; i<vertex_count; i++) {
        graph2->graph[i] = (int *)malloc(sizeof(int)*vertex_count);
        for(int j=0; j<vertex_count; j++) {
            graph2->graph[i][j] = 0;
        }
    }
}

void get_input_graph(graph_AL *graph1, graph_AM *graph2, int edge_count) {
    for(int i=0; i<edge_count; i++) {
        printf("Enter edge %d {v1 v2} format : ", i);
        int v1=0, v2=0;
        scanf("%d%d", &v1, &v2);
        
        Node *newNode_v2 = (Node *)malloc(sizeof(Node));
        newNode_v2->vertex = v2;
        newNode_v2->next = NULL;
        Node *temp = graph1->graph[v1];
        while(temp->next != NULL) temp=temp->next;
        temp->next = newNode_v2;

        Node *newNode_v1 = (Node *)malloc(sizeof(Node));
        newNode_v1->vertex = v1;
        newNode_v1->next = NULL;
        temp = graph1->graph[v2];
        while(temp->next != NULL) temp=temp->next;
        temp->next = newNode_v1;

        graph2->graph[v1][v2]=1;
        graph2->graph[v2][v1]=1; 
    }
}

void print_adjacency_list(graph_AL *graph) {
    printf("\nADJACENCY LIST : \n");
    for(int i=0; i<graph->vertex_count; i++) {
        Node *temp = graph->graph[i];
        printf("[%d] :", temp->vertex);
        temp=temp->next;
        while(temp!=NULL) {
            printf(" %d", temp->vertex);
            temp=temp->next;
        } printf("\n");
    }
}

void print_adjacency_matrix(graph_AM *graph) {
    printf("\nADJACENCY MATRIX : \n");
    printf("%3s", "V");
    for(int i=0; i<graph->vertex_count; i++) {
        printf(" %3d", i);
    } printf("\n");
    for(int i=0; i<graph->vertex_count; i++) {
        printf("%3d", i);
        for(int j=0; j<graph->vertex_count; j++) {
            printf(" %3d", graph->graph[i][j]);
        } printf("\n");
    }
}

void dfs_adjacency_list_recursive(graph_AL *graph, int current_node, int *visited) {
    printf(" %d", current_node);
    Node *temp = graph->graph[current_node]->next;
    while(temp!=NULL) {
        if(visited[temp->vertex]==0) {
            visited[temp->vertex]=1;
            dfs_adjacency_list_recursive(graph, temp->vertex, visited);
        }
        temp=temp->next;
    }
}

void dfs_adjacency_list_non_recursive(graph_AL *graph) {
    printf("\nDFS ADJACENCY LIST, NON-RECURSIVE\n");
    stack *s = NULL;
    int *visited = (int *)calloc(graph->vertex_count, sizeof(int));
    
    visited[0]=1;
    push(&s, 0);
    printf(" 0");

    while(isEmpty(&s)==0) {
        int current_vertex = peek(&s);
        Node *temp = graph->graph[current_vertex]->next;
        while(temp!=NULL) {
            if(visited[temp->vertex]==0) {
                visited[temp->vertex]=1;
                printf(" %d", temp->vertex);
                push(&s, temp->vertex);
                break;
            } temp=temp->next;
        } if(temp==NULL) pop(&s);
    }
}

void dfs_adjacency_matrix_recursive(graph_AM *graph, int current_node, int *visited) {
    printf(" %d", current_node);
    for(int i=0; i<graph->vertex_count; i++) {
        if(visited[i]==0 && graph->graph[current_node][i]) {
            visited[i]=1;
            dfs_adjacency_matrix_recursive(graph, i, visited);
        }
    }
}

void dfs_adjacency_matrix_non_recursive(graph_AM *graph) {
    printf("\nDFS ADJACENCY MATRIX, NON-RECURSIVE\n");
    stack *s = NULL;
    int *visited = (int *)calloc(graph->vertex_count, sizeof(int));
    
    visited[0]=1;
    push(&s, 0);
    printf(" 0");

    while(isEmpty(&s)==0) {
        int current_vertex = peek(&s);
        bool hasNext = 0;
        for(int i=0; i<graph->vertex_count; i++) {
            if(visited[i]==0 && graph->graph[current_vertex][i]==1) {
                visited[i]=1;
                printf(" %d", i);
                push(&s, i);
                hasNext=1;
                break;
            }
        } if(hasNext==0) pop(&s);
    }
}