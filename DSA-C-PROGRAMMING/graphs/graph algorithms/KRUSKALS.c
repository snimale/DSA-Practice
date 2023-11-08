#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define infinity 99

typedef struct graph_AM {
    int vertex_count;
    int **graph;
} graph_AM;

typedef struct Node {
    int vertex;
    int weight;
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
int not_same_original_parent(int, int, int *);
void update_original_parent(int, int, int *);
void print_minimum_spanning_adjacency_matrix(graph_AM *);
void print_minimum_spanning_adjacency_list(graph_AL *);


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
    print_adjacency_matrix(&graph2);
    print_minimum_spanning_adjacency_matrix(&graph2);
    print_minimum_spanning_adjacency_list(&graph1);
}

void init_graph(graph_AL *graph1, graph_AM *graph2, int vertex_count) {
    graph1->vertex_count = vertex_count;
    graph2->vertex_count = vertex_count;
    
    graph1->graph = (Node **)malloc(sizeof(Node *)*vertex_count);
    for(int i=0; i<vertex_count; i++) {
        graph1->graph[i] = (Node *)malloc(sizeof(Node));
        graph1->graph[i] -> vertex = i;
        graph1->graph[i] -> weight = infinity;
        graph1->graph[i] -> next = NULL;
    }

    graph2->graph = (int **)malloc(sizeof(int *)*vertex_count);
    for(int i=0; i<vertex_count; i++) {
        graph2->graph[i] = (int *)malloc(sizeof(int)*vertex_count);
        for(int j=0; j<vertex_count; j++) {
            graph2->graph[i][j] = infinity;
        }
    }
}

void get_input_graph(graph_AL *graph1, graph_AM *graph2, int edge_count) {
    for(int i=0; i<edge_count; i++) {
        printf("Enter edge %d {v1 v2} format : ", i);
        int v1=0, v2=0;
        int w=infinity;
        scanf("%d%d%d", &v1, &v2, &w);
        
        Node *newNode_v2 = (Node *)malloc(sizeof(Node));
        newNode_v2->vertex = v2;
        newNode_v2->next = NULL;
        newNode_v2->weight = w;

        Node *temp = graph1->graph[v1];
        while(temp->next != NULL) temp=temp->next;
        temp->next = newNode_v2;

        Node *newNode_v1 = (Node *)malloc(sizeof(Node));
        newNode_v1->vertex = v1;
        newNode_v1->next = NULL;
        newNode_v1->weight = w;
        temp = graph1->graph[v2];
        while(temp->next != NULL) temp=temp->next;
        temp->next = newNode_v1;

        graph2->graph[v1][v2]=w;
        graph2->graph[v2][v1]=w; 
    }
}

void print_adjacency_list(graph_AL *graph) {
    printf("\nADJACENCY LIST : \n");
    for(int i=0; i<graph->vertex_count; i++) {
        Node *temp = graph->graph[i];
        printf("[%d] :", temp->vertex);
        temp=temp->next;
        while(temp!=NULL) {
            printf(" %d(w=%d)", temp->vertex, temp->weight);
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

void update_original_parent(int a, int b, int *parents) {
    while(a!=parents[a]) a=parents[a];
    parents[a]=b;
}

int not_same_original_parent(int a, int b, int *parents) {
    while(a!=parents[a]) a=parents[a];
    while(b!=parents[b]) b=parents[b];
    if(a!=b) return 1;
    else return 0;
}

void print_minimum_spanning_adjacency_matrix(graph_AM *graph) {
    printf("\nMINIMUM SPANNING TREE (USING MATRIX) : \n");
    int *original_parent = (int *)calloc(graph->vertex_count, sizeof(int));
    for(int i=0; i<graph->vertex_count; i++)
        original_parent[i]=i;

    for(int i=0; i<graph->vertex_count-1; i++) {
        int min_distance=infinity;
        int v1=-1, v2=-1;
        for(int j=0; j<graph->vertex_count; j++) {
            for(int k=0; k<graph->vertex_count; k++) {
                if(min_distance>graph->graph[j][k] && not_same_original_parent(j, k, original_parent)==1) {
                    min_distance=graph->graph[j][k];
                    v1=j; v2=k;
                }
            }
        }

        printf("%d - %d\n", v1, v2);
        update_original_parent(v1, v2, original_parent);
    }
}

void print_minimum_spanning_adjacency_list(graph_AL *graph) {
    printf("\nMINIMUM SPANNING TREE (USING LIST) : \n");
    int *original_parent = (int *)calloc(graph->vertex_count, sizeof(int));
    for(int i=0; i<graph->vertex_count; i++)
        original_parent[i]=i;

    for(int i=0; i<graph->vertex_count-1; i++) {
        int min_distance=infinity;
        int v1=-1, v2=-1;
        for(int j=0; j<graph->vertex_count; j++) {
            Node *temp = graph->graph[j]->next;
            while(temp!=NULL) {
                if(min_distance>temp->weight && not_same_original_parent(j, temp->vertex, original_parent)==1) {
                    min_distance=temp->weight;
                    v1=j; v2=temp->vertex;
                }
                temp=temp->next;
            }
        }

        printf("%d - %d\n", v1, v2);
        update_original_parent(v1, v2, original_parent);
    }
}