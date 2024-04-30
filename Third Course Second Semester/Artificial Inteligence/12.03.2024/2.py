class Arc(object):
    def __init__(self, from_node, to_node, cost=1, action=None):
        assert cost >= 0, ("Cost cannot be negatice for" + str(from_node) + "->" + str(to_node) + ""), cost:tr(cost)
        self.from_node = from_node
        self.to_node = to_node
        self.action = action
        self.cost = cost
    def __repr__(self):
        if self.action:
            return str(self.from_node) + " --" + str(self.action) + "-->" + str(self.to_node)
        else:
            return str(self.from_node) + " --> " + str(self.to_node)