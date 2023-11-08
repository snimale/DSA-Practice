#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

//----------------------------------------- QUEUE IMPLEMENTATION START -----------------------------------------//

typedef struct queue_node {
    int data;
    struct queue_node *next;
} queue;

void enqueue(queue **q, int data) {
    if (*q == NULL) {
        queue *newQueue = (queue *)malloc(sizeof(queue));
        newQueue -> data = data;
        newQueue -> next = NULL;
        *q = newQueue;
    } else {
        queue *temp = *q;
        while(temp->next != NULL) {
            temp = temp->next;
        }
        queue *newQueue = (queue *)malloc(sizeof(queue));
        newQueue -> data = data;
        newQueue -> next = NULL;
        temp->next = newQueue;
    }
}

int dequeue(queue **q) {
    if(*q == NULL) return -1;
    else {
        int data = (*q)->data;
        *q = (*q)->next;
        return data;
    }
}

int isEmpty(queue **q) {
    if(*q == NULL) return 1;
    else return 0;
}

//----------------------------------------- QUEUE IMPLEMENTATION END -------------------------------------------//


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
void bfs_adjacency_list(graph_AL *);
void bfs_adjacency_matrix(graph_AM *);

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
    bfs_adjacency_list(&graph1);

    print_adjacency_matrix(&graph2);
    bfs_adjacency_matrix(&graph2);
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

void bfs_adjacency_list(graph_AL *graph) {
    printf("\nBFS ADJACENCY LIST : \n");

    int *visited = (int *)malloc(sizeof(int)*graph->vertex_count);
    for(int i=0; i<graph->vertex_count; i++) visited[i] = 0;
    queue *q = NULL;
    
    enqueue(&q, 0);
    visited[0]=1;
    while(isEmpty(&q)==0) {
        int current_vertex = dequeue(&q);
        printf(" %d", current_vertex);
        
        Node *temp = graph->graph[current_vertex]->next;
        while(temp!=NULL) {
            if(visited[temp->vertex]==0) {
                visited[temp->vertex]=1;
                enqueue(&q, temp->vertex);
            } temp=temp->next;
        }
    } printf("\n");
}

void bfs_adjacency_matrix(graph_AM *graph) {
    printf("\nBFS ADJACENCY MATRIX : \n");

    int *visited = (int *)malloc(sizeof(int) *graph->vertex_count);
    for(int i=0; i<graph->vertex_count; i++) visited[i]=0;
    queue *q;

    enqueue(&q, 0);
    visited[0]=1;
    while(isEmpty(&q)==0) {
        int current_vertex = dequeue(&q);
        printf(" %d", current_vertex);

        for(int i=0; i<graph->vertex_count; i++) {
            if(graph->graph[current_vertex][i]==1 && visited[i]==0) {
                visited[i]=1;
                enqueue(&q, i);
            }
        }
    } printf("\n");
}