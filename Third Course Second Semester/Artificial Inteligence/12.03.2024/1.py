class Search_problem(object):
    def start_node(self):
        raise NotImplementedError("start node")
    def is_goal(self, node):
        raise NotImplementedError("is goal")
    def neighbours(self, node):
        raise NotImplementedError("neighbours")
    def heuristic(self, n):
        return 0