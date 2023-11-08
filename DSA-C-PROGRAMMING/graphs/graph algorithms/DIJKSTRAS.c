#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<math.h>
#define infinity 99

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
void print_shortest_path_from_source_using_list(int, graph_AL *);
void print_shortest_path_from_source_using_matrix(int, graph_AM *);
void print_paths(int *, int *, int, int);

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

    print_shortest_path_from_source_using_list(0, &graph1);
    print_shortest_path_from_source_using_matrix(0, &graph2);
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

        graph2->graph[v1][v2]=w;
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

void print_shortest_path_from_source_using_list(int source, graph_AL *graph) {
    int *visited = (int *)calloc(graph->vertex_count, sizeof(int));
    int *parent = (int *)calloc(graph->vertex_count, sizeof(int));
    int *distance = (int *)calloc(graph->vertex_count, sizeof(int));
    for(int i=0; i<graph->vertex_count; i++)
        distance[i]=infinity;
    distance[source]=0;

    for(int i=0; i<graph->vertex_count; i++) {
        int min_distance = infinity;
        int chosen_vertex = -1;
        for(int j=0; j<graph->vertex_count; j++) {
            if(min_distance>distance[j] && visited[j]==0) {
                chosen_vertex=j;
            }
        }

        visited[chosen_vertex]=1;
        Node *temp = graph->graph[chosen_vertex]->next;
        while(temp!=NULL) {
            if(distance[temp->vertex] > distance[chosen_vertex]+temp->weight) {
                distance[temp->vertex] = distance[chosen_vertex]+temp->weight;
                parent[temp->vertex] = chosen_vertex;
            } temp=temp->next;
        }
    } print_paths(distance, parent, graph->vertex_count, source);
}

void print_shortest_path_from_source_using_matrix(int source, graph_AM *graph) {
    int *visited = (int *)calloc(graph->vertex_count, sizeof(int));
    int *parent = (int *)calloc(graph->vertex_count, sizeof(int));
    int *distance = (int *)calloc(graph->vertex_count, sizeof(int));
    for(int i=0; i<graph->vertex_count; i++)
        distance[i]=infinity;
    distance[source]=0;

    for(int i=0; i<graph->vertex_count; i++) {
        int min_distance = infinity;
        int chosen_vertex = -1;
        for(int j=0; j<graph->vertex_count; j++) {
            if(min_distance>distance[j] && visited[j]==0) {
                chosen_vertex=j;
            }
        }

        visited[chosen_vertex]=1;
        for(int j=0; j<graph->vertex_count; j++) {
            if(distance[j] > distance[chosen_vertex]+graph->graph[chosen_vertex][j] && graph->graph[chosen_vertex][j]!=infinity) {
                distance[j] = distance[chosen_vertex]+graph->graph[chosen_vertex][j];
                parent[j] = chosen_vertex;
            }
        }
    } print_paths(distance, parent, graph->vertex_count, source);
}

void print_paths(int *distance, int *parent, int n, int source) {
    printf("\nSHORTEST PATHS FROM %d", source);
    for(int i=0; i<n; i++) {
        printf("\n%d", source);
        if(i!=source) {
            int temp=i;
            stack *s=NULL;
            while(temp!=source) {
                push(&s, temp);
                temp=parent[temp];
            }
            while(isEmpty(&s)==0) {
                printf("->%d", pop(&s));
            }
        }
    } printf("\n");
}